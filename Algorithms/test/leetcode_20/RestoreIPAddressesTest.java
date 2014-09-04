package leetcode_20;

import static org.junit.Assert.*;

import org.junit.Test;

public class RestoreIPAddressesTest {

	@Test
	public void test() {
		RestoreIPAddresses r = new RestoreIPAddresses();
		assertEquals(r.restoreIpAddresses("25525511135").toString(), "[255.255.11.135, 255.255.111.35]");
		assertEquals(r.restoreIpAddresses("010010").toString(), "[0.10.0.10, 0.100.1.0]");
	}

}
