package com.logistics.packaging

import com.logistics.packaging.model.Input
import com.logistics.packaging.service.PackagingService
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class PackagingApplicationTests {

	@Autowired
	lateinit var packagingService: PackagingService

	@Test
	fun contextLoads() {
	}

	@Test
	fun test81() {
		// Given
		val input = "81 : (1,53.38,€45) (2,88.62,€98) (3,78.48,€3) (4,72.30,€76) (5,30.18,€9) (6,46.34,€48)"

		// When
		val output = packagingService.pack(Input(input))

		// Then
		assertEquals("4", output.toString())
	}

	@Test
	fun testNothing() {
		// Given
		val input = "8 : (1,15.3,€34)"

		// When
		val output = packagingService.pack(Input(input))

		// Then
		assertEquals("-", output.toString())
	}

	@Test
	fun test75() {
		// Given
		val input = "75 : (1,85.31,€29) (2,14.55,€74) (3,3.98,€16) (4,26.24,€55) (5,63.69,€52) (6,76.25,€75) (7,60.02,€74) (8,93.18,€35) (9,89.95,€78)"

		// When
		val output = packagingService.pack(Input(input))

		// Then
		assertEquals("2,7", output.toString())
	}

	@Test
	fun test56() {
		// Given
		val input = "56 : (1,90.72,€13) (2,33.80,€40) (3,43.15,€10) (4,37.97,€16) (5,46.81,€36) (6,48.77,€79) (7,81.80,€45) (8,19.36,€79) (9,6.76,€64)"

		// When
		val output = packagingService.pack(Input(input))

		// Then
		assertEquals("8,9", output.toString())
	}

}
