package com.shakaalgang.utils;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.Silent.class)
public class CommonUtilsTest {

    @Spy
    CommonUtils commonUtils;

    @Test
    public void riskyProfile() {
        Boolean result = commonUtils.testCheck(1000, 500);
        assertTrue(result);
    }
}
