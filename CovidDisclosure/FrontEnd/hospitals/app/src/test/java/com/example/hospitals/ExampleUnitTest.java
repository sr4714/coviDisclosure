package com.example.hospitals;

import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void showNearByPlaceData()  throws Exception {
        Object showNearByPlaceData = null;

        assertThat(showNearByPlaceData.equals("Mary Greeley Medical Center"));
    }

    private void assertThat(boolean mary_greeley_medical_center) {
        DataAnalyze getPlace = new DataAnalyze();
    }


}