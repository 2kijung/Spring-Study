package com.kh.spring.common.batch;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BaseballBatch {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private BatchRepository batchRepository;

	
	//cron 표현식
	// 초 분 시 일 월 요일 년(스프링에서 사용안함)
	// * : 모든
	// , : 복수 값을 지정
	// 시작시간/ 단위 : 시작시간부터 지정한 단위마다 실행
	// 0초 0분 3시 * * * => 매일 새벽 3시에 배치를 실행
	// 0 0 3,6,22 * * * => 새벽 3시, 아침 6시, 밤 10시에 배치실행
	// 0 0/15 * * * * => 15분 마다 배치 실행
	
	@Scheduled(cron = "0 20 15 7 12 *")
	public void baseballBatch() {
		try {
			Document doc = Jsoup.connect("https://www.koreabaseball.com/TeamRank/TeamRank.aspx").get();
			Elements teamList = doc.select("#cphContents_cphContents_cphContents_udpRecord > table > tbody > tr");
			List<Map<String, String>> dataList = getRankDataList(teamList);
			for (Map<String, String> map : dataList) {
				batchRepository.insertBaseballRank(map);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		logger.debug("6개월간 수고 많으셨습니다."
				+ " 앞으로 좋은 일만 있으시고 "
				+ "훌룡한 프로그래머가 되시길 기원합니다.");
	}
	private List<Map<String, String>> getRankDataList(Elements teamList) {
		String[] keyArr = { "rank", "name", "game", "win", "lose", "tie" };
		List<Map<String, String>> dataList = new ArrayList<>();

		for (Element team : teamList) {
			Elements datas = team.getElementsByTag("td");
			Map<String, String> data = new HashMap<>();

			for (int i = 0; i < 6; i++) {
				data.put(keyArr[i], datas.get(i).text());
			}
			dataList.add(data);
		}
		return dataList;
	}
}