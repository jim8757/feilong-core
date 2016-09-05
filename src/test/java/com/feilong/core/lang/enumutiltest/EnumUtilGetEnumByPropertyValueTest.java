/*
 * Copyright (C) 2008 feilong
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.feilong.core.lang.enumutiltest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.feilong.core.bean.BeanUtilException;
import com.feilong.core.entity.HttpMethodTestType;
import com.feilong.core.lang.EnumUtil;

public class EnumUtilGetEnumByPropertyValueTest{

    /**
     * Test get enum.
     */
    @Test
    public void testGetEnum(){
        assertEquals(HttpMethodTestType.GET, EnumUtil.getEnumByPropertyValue(HttpMethodTestType.class, "method", "get"));
    }

    /**
     * Test get http method type.
     */
    @Test
    public void testGetHttpMethodType(){
        assertEquals(HttpMethodTestType.POST, EnumUtil.getEnumByPropertyValue(HttpMethodTestType.class, "method", "post"));
        assertEquals(HttpMethodTestType.POST, EnumUtil.getEnumByPropertyValue(HttpMethodTestType.class, "method", "pOst"));
        assertEquals(HttpMethodTestType.POST, EnumUtil.getEnumByPropertyValue(HttpMethodTestType.class, "method", "POST"));
        assertEquals(HttpMethodTestType.POST, EnumUtil.getEnumByPropertyValue(HttpMethodTestType.class, "method", "posT"));
        assertEquals(HttpMethodTestType.GET, EnumUtil.getEnumByPropertyValue(HttpMethodTestType.class, "method", "get"));
        assertEquals(HttpMethodTestType.GET, EnumUtil.getEnumByPropertyValue(HttpMethodTestType.class, "method", "gEt"));
        assertEquals(HttpMethodTestType.GET, EnumUtil.getEnumByPropertyValue(HttpMethodTestType.class, "method", "geT"));
        assertEquals(HttpMethodTestType.GET, EnumUtil.getEnumByPropertyValue(HttpMethodTestType.class, "method", "GET"));

    }

    /**
     * Test get http method type 1.
     */
    @Test
    public void testGetHttpMethodType1(){
        assertEquals(null, EnumUtil.getEnumByPropertyValue(HttpMethodTestType.class, "method", "post111"));
    }

    /**
     * Test get http method type2.
     */
    @Test
    public void testGetHttpMethodType2(){
        assertEquals(null, EnumUtil.getEnumByPropertyValue(HttpMethodTestType.class, "method", ""));
    }

    /**
     * Test get http method type3.
     */
    @Test
    public void testGetHttpMethodType3(){
        assertEquals(null, EnumUtil.getEnumByPropertyValue(HttpMethodTestType.class, "method", null));
    }

    /**
     * Test get http method type4.
     */
    @Test(expected = BeanUtilException.class)
    public void testGetHttpMethodType4(){
        assertEquals(null, EnumUtil.getEnumByPropertyValue(HttpMethodTestType.class, "method2222", null));
    }
}