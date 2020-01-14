package com.telran;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.junit.Assert.*;

public class ParenthesesCheckTest {

    ParenthesesCheck revise = new ParenthesesCheck();

    @Test
    public void testReviseParentheses_withoutFail() {
        String text = "ab (cd) ee [a] cdf {v} gtr.";

        assertEquals(0,revise.reviseOfParentheses(text));

    }

    @Test
    public void testReviseParentheses_withFail_roundBrackets() {
        String text = "ab (c [d) ee] cd {fd} gtr.";

        assertEquals(1,revise.reviseOfParentheses(text));

    }

    @Test
    public void testReviseParentheses_withFail_moreThanOneOpenRoundBrackets() {
        String text = "ab (c (d( ee) cd {fd} gtr.";

        assertEquals(1,revise.reviseOfParentheses(text));

    }

    @Test
    public void testReviseParentheses_withFail_onlyOneOpenBrackets() {
        String text = "ab (c (d( ee cd (fd( gtr.";

        assertEquals(1,revise.reviseOfParentheses(text));

    }

    @Test
    public void testReviseParentheses_withFail_onlyOneCloseBrackets() {
        String text = "ab )c )d) ee cd )fd) gtr.";

        assertEquals(1,revise.reviseOfParentheses(text));

    }

    @Test
    public void testReviseParentheses_withFail_onlyOneCloseSquareBrackets() {
        String text = "ab ]c ]d] ee cd ]fd] gtr.";

        assertEquals(1,revise.reviseOfParentheses(text));

    }

    @Test
    public void testReviseParentheses_withFail_onlyOneCloseMixBrackets() {
        String text = "ab }c }d] ee cd )fd] gtr.";

        assertEquals(1,revise.reviseOfParentheses(text));

    }

    @Test
    public void testReviseParentheses_withFail_squareBrackets() {
        String text = "ab [c [d) ee] cd {fd} gtr.";

        assertEquals(1,revise.reviseOfParentheses(text));

    }

    @Test
    public void testReviseParentheses_withFail_braces() {
        String text = "ab {c [d} ee] cd (fd) gtr.";

        assertEquals(1,revise.reviseOfParentheses(text));

    }

}