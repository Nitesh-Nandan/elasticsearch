package com.nitesh.elk.time;

import java.time.Duration;
import java.time.Instant;

public class TimeCalculator {

	public static void main(String[] args) throws InterruptedException {
		Instant start = Instant.now();
		Thread.sleep(1200);
		Instant end = Instant.now();
		Duration timeElapsed = Duration.between(start, end);

		System.out.println(timeElapsed.getSeconds());

		long start1 = System.currentTimeMillis();
		Thread.sleep(1200);
		long end1 = System.currentTimeMillis();
		long elapsedTime = end1 - start1;
		
		System.out.println(elapsedTime);
	}

}
