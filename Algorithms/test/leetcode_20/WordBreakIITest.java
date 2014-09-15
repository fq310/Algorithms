package leetcode_20;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class WordBreakIITest {

	@Test
	public void test() {
		WordBreakII w = new WordBreakII();
		Set<String> dict = new HashSet<>();
		dict.add("cat"); dict.add("cats");dict.add("and"); dict.add("sand");dict.add("dog");
		w.wordBreak("catsanddog", dict);
		
		dict = getDict(new String[] {"o","b","gbdfgiokkfnhl","glibjohcmd","bblcnhelanckn","mflabckflflja","mgda","oheafhajjo","cc","cffalholojikojm","haljiamccabh","gjkdlonmhdacd","ee","bc","mjj","fdlmmbhij","nn","jiaaifedaihn","nhligg","hooaglldlei","hajhebh","ebijeeh","me","eibm","ekkobhajgkem","ohaofonhjakc","n","kjjogm","mhn","odcamjmodie","edmagbkejiocacl","kcbfnjialef","lhifcohoe","akgnn","fbgakjhjb","belggjekmn","oinedhhnolc","ddekcnag","oneoakldakalb","bodnokemafkhkhf","dkefeddjdnab","gflcngff","fgnfmbcogmojgm","ad","jadhganf","lojckbdfj","gadkaoe","jdam","ljjndlnednnombl","aggegbnngohbgga"});
		w.wordBreak("aggegbnngohbggalojckbdfjakgnnjadhganfdkefeddjdnabmflabckflfljafdlmmbhijojiaaifedaihnoinedhhnolcjdam", dict);
	}

	private Set<String> getDict(String[] strings) {
		Set<String> dict = new HashSet<>();
		for (String s : strings) {
			dict.add(s);
		}
		return dict;
	}

}
