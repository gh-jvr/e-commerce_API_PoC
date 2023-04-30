package jvr.poc.price;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.JUnitException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * Junit main test class.
 */
@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
class PriceApplicationTests {

	/**
	 * Constant which defines the API end-point for the test.
	 */
    private static final String END_POINT = "/price";

	/**
	 * Constant which defines the input request for the test 1.
	 */
    private static final String REQUEST_JSON_TEST_1 = "{ \"application_date\": \"2020-06-14-10.00.00\", \"product_id\": 35455, \"brand_id\": 1 }";

	/**
	 * Constant which defines the input request for the test 2.
	 */
    private static final String REQUEST_JSON_TEST_2 = "{ \"application_date\": \"2020-06-14-16.00.00\", \"product_id\": 35455, \"brand_id\": 1 }";

	/**
	 * Constant which defines the input request for the test 3.
	 */
    private static final String REQUEST_JSON_TEST_3 = "{ \"application_date\": \"2020-06-14-21.00.00\", \"product_id\": 35455, \"brand_id\": 1 }";

	/**
	 * Constant which defines the input request for the test 4.
	 */
    private static final String REQUEST_JSON_TEST_4 = "{ \"application_date\": \"2020-06-15-10.00.00\", \"product_id\": 35455, \"brand_id\": 1 }";

	/**
	 * Constant which defines the input request for the test 5.
	 */
    private static final String REQUEST_JSON_TEST_5 = "{ \"application_date\": \"2020-06-16-21.00.00\", \"product_id\": 35455, \"brand_id\": 1 }";

	/**
	 * Call mocker instance for API tests.
	 */
    @Autowired
    protected MockMvc mvc;

	/**
	 * Test 1.
	 * 	Date: 2020-06-14 10:00
	 * 	Product ID: 35455
	 * 	Brand ID: 1
	 * <p>
	 * 	Expected result: Only price with fee = 1.
	 * @throws JUnitException if something went wrong.
	 */
    @Test
    public void test1() throws JUnitException {
        MvcResult mvcResult;
        try {
            mvcResult = mvc.perform(MockMvcRequestBuilders.post(END_POINT).contentType(MediaType.APPLICATION_JSON_VALUE).content(REQUEST_JSON_TEST_1)).andReturn();

            MockHttpServletResponse response = mvcResult.getResponse();
            int status = response.getStatus();

            Assertions.assertEquals(200, status);

            Assertions.assertTrue(response.getContentAsString().contains("\"fee\":1"));

			Assertions.assertFalse(response.getContentAsString().contains("\"fee\":2"));
			Assertions.assertFalse(response.getContentAsString().contains("\"fee\":3"));
			Assertions.assertFalse(response.getContentAsString().contains("\"fee\":4"));

        } catch (Exception e) {
            throw new JUnitException(e.getMessage(), e);
        }
    }

	/**
	 * Test 2.
	 * 	Date: 2020-06-14 14:00
	 * 	Product ID: 35455
	 * 	Brand ID: 1
	 * <p>
	 * 	Expected result: Only price with fee = 1 and 2.
	 * @throws JUnitException if something went wrong.
	 */
    @Test
    public void test2() throws JUnitException {
        MvcResult mvcResult;
        try {
            mvcResult = mvc.perform(MockMvcRequestBuilders.post(END_POINT).contentType(MediaType.APPLICATION_JSON_VALUE).content(REQUEST_JSON_TEST_2)).andReturn();

            MockHttpServletResponse response = mvcResult.getResponse();
            int status = response.getStatus();

            Assertions.assertEquals(200, status);

            Assertions.assertTrue(response.getContentAsString().contains("\"fee\":1"));
			Assertions.assertTrue(response.getContentAsString().contains("\"fee\":2"));

			Assertions.assertFalse(response.getContentAsString().contains("\"fee\":3"));
			Assertions.assertFalse(response.getContentAsString().contains("\"fee\":4"));

        } catch (Exception e) {
            throw new JUnitException(e.getMessage(), e);
        }
    }

	/**
	 * Test 3.
	 * 	Date: 2020-06-14 21:00
	 * 	Product ID: 35455
	 * 	Brand ID: 1
	 * <p>
	 * 	Expected result: Only price with fee = 1.
	 * @throws JUnitException if something went wrong.
	 */
    @Test
    public void test3() throws JUnitException {
        MvcResult mvcResult;
        try {
            mvcResult = mvc.perform(MockMvcRequestBuilders.post(END_POINT).contentType(MediaType.APPLICATION_JSON_VALUE).content(REQUEST_JSON_TEST_3)).andReturn();

            MockHttpServletResponse response = mvcResult.getResponse();
            int status = response.getStatus();

            Assertions.assertEquals(200, status);

            Assertions.assertTrue(response.getContentAsString().contains("\"fee\":1"));

			Assertions.assertFalse(response.getContentAsString().contains("\"fee\":2"));
			Assertions.assertFalse(response.getContentAsString().contains("\"fee\":3"));
			Assertions.assertFalse(response.getContentAsString().contains("\"fee\":4"));

        } catch (Exception e) {
            throw new JUnitException(e.getMessage(), e);
        }
    }

	/**
	 * Test 4.
	 * 	Date: 2020-06-15 10:00
	 * 	Product ID: 35455
	 * 	Brand ID: 1
	 * <p>
	 * 	Expected result: Only price with fee = 1 and 3.
	 * @throws JUnitException if something went wrong.
	 */
    @Test
    public void test4() throws JUnitException {
        MvcResult mvcResult;
        try {
            mvcResult = mvc.perform(MockMvcRequestBuilders.post(END_POINT).contentType(MediaType.APPLICATION_JSON_VALUE).content(REQUEST_JSON_TEST_4)).andReturn();

            MockHttpServletResponse response = mvcResult.getResponse();
            int status = response.getStatus();

            Assertions.assertEquals(200, status);

            Assertions.assertTrue(response.getContentAsString().contains("\"fee\":1"));
			Assertions.assertTrue(response.getContentAsString().contains("\"fee\":3"));

			Assertions.assertFalse(response.getContentAsString().contains("\"fee\":2"));
			Assertions.assertFalse(response.getContentAsString().contains("\"fee\":4"));

        } catch (Exception e) {
            throw new JUnitException(e.getMessage(), e);
        }
    }

	/**
	 * Test 5.
	 * 	Date: 2020-06-16 21:00
	 * 	Product ID: 35455
	 * 	Brand ID: 1
	 * <p>
	 * 	Expected result: Only price with fee = 1 and 4.
	 * @throws JUnitException if something went wrong.
	 */
    @Test
    public void test5() throws JUnitException {
        MvcResult mvcResult;
        try {
            mvcResult = mvc.perform(MockMvcRequestBuilders.post(END_POINT).contentType(MediaType.APPLICATION_JSON_VALUE).content(REQUEST_JSON_TEST_5)).andReturn();

            MockHttpServletResponse response = mvcResult.getResponse();
            int status = response.getStatus();

            Assertions.assertEquals(200, status);

            Assertions.assertTrue(response.getContentAsString().contains("\"fee\":1"));
			Assertions.assertTrue(response.getContentAsString().contains("\"fee\":4"));

			Assertions.assertFalse(response.getContentAsString().contains("\"fee\":2"));
			Assertions.assertFalse(response.getContentAsString().contains("\"fee\":3"));

        } catch (Exception e) {
            throw new JUnitException(e.getMessage(), e);
        }
    }

}
