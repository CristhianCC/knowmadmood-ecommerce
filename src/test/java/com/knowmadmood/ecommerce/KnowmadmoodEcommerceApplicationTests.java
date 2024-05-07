package com.knowmadmood.ecommerce;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class KnowmadmoodEcommerceApplicationTests {

	@MockBean
	KnowmadmoodEcommerceApplication knowmadmoodEcommerceApplication;

	@Test
	void contextLoads() {
	}

	@Test
	void applicationStartTest() {
		KnowmadmoodEcommerceApplication.main(new String[]{});
	}

}
