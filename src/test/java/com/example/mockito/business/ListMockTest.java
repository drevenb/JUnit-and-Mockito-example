package com.example.mockito.business;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyInt;

public class ListMockTest {

    List<String> mockList = Mockito.mock(List.class);

    @Test
    public void size_basic() {
        Mockito.when(mockList.size()).thenReturn(5);
        assertEquals(5, mockList.size());
    }

    @Test
    public void return_different_values() {
        Mockito.when(mockList.size()).thenReturn(5).thenReturn(10);
        assertEquals(5, mockList.size());
        assertEquals(10, mockList.size());
    }

    @Test
    public void return_with_parameters() {
        Mockito.when(mockList.get(0)).thenReturn("sasha");
        assertEquals("sasha", mockList.get(0));
        assertNull(mockList.get(1));
    }

    @Test
    public void return_with_generic_parameters() {
        Mockito.when(mockList.get(anyInt())).thenReturn("hello");
        assertEquals("hello", mockList.get(0));
        assertEquals("hello", mockList.get(1));
    }

    @Test
    public void verification_basic() {
        //SUT
        String value1 = mockList.get(0);
        String value2 = mockList.get(1);

        //Verify
        Mockito.verify(mockList).get(0);
        Mockito.verify(mockList, Mockito.times(2)).get(anyInt());
        Mockito.verify(mockList, Mockito.atLeast(1)).get(anyInt());
        Mockito.verify(mockList, Mockito.atLeastOnce()).get(anyInt());
        Mockito.verify(mockList, Mockito.atMost(3)).get(anyInt());
        Mockito.verify(mockList, Mockito.never()).get(2);
    }

    @Test
    public void argument_Capturing() {
        //SUT
        mockList.add("something1");
        mockList.add("something2");

        //Verification
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        Mockito.verify(mockList, Mockito.times(2)).add(captor.capture());

        List<String> allValues = captor.getAllValues();
        assertEquals("something1", allValues.get(0));
        assertEquals("something2", allValues.get(1));
    }

    @Test
    public void mocking() {
        ArrayList arrayListMock = Mockito.mock(ArrayList.class);

        System.out.println(arrayListMock.get(0));//null
        System.out.println(arrayListMock.size());//0
        System.out.println(arrayListMock.add("test"));//false
        System.out.println(arrayListMock.add("test2"));//false
        System.out.println(arrayListMock.size());//0

        Mockito.when(arrayListMock.size()).thenReturn(5);
        System.out.println(arrayListMock.size());//5

        assertEquals(null, arrayListMock.get(0));
    }

    @Test
    public void spying() {
        ArrayList arrayListSpy = Mockito.spy(ArrayList.class);
        arrayListSpy.add("test");

        System.out.println(arrayListSpy.get(0));//test
        System.out.println(arrayListSpy.size());//1
        System.out.println(arrayListSpy.add("test1"));//true
        System.out.println(arrayListSpy.add("test2"));//true
        System.out.println(arrayListSpy.size());//3

        Mockito.when(arrayListSpy.size()).thenReturn(5);
        System.out.println(arrayListSpy.size());//5

        arrayListSpy.add("test3");
        System.out.println(arrayListSpy.size());//5

        assertEquals("test", arrayListSpy.get(0));
    }
}
