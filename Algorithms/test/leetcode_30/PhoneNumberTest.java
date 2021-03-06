package leetcode_30;

import static org.junit.Assert.*;
import leetcode_30.PhoneNumber;

import org.junit.Test;

public class PhoneNumberTest {

	@Test
	public void testLetterCombinations() {
		PhoneNumber p = new PhoneNumber();
		assertEquals(p.letterCombinations("").toString(), "[]");
		assertEquals(p.letterCombinations("2").toString(), "[a, b, c]");
		assertEquals(p.letterCombinations("23").toString(), 
				"[ad, ae, af, bd, be, bf, cd, ce, cf]");
	}

}
