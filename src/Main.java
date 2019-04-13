import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] arg) {
		//给定一个字符串，由纯小写英文字母组成，无重复字符
		String input = "abcdef";

	//	List<String> result = getResult(input);

		List<String> list = new ArrayList<>();
		List<String> list2 = new ArrayList<>();

		list.add("a");
		list.add("b");
		list.add("c");

		list2 = list.stream().filter(item -> item.equals("a")).collect(Collectors.toList());
		System.out.println(list);
		System.out.println(list2);


	//	System.out.println(result.size());
	//	System.out.println(result);
	}
	
	public static List<String> getResult(String input) {
		int length = input.length();
		int size = 1;
		while(length != 0) {
			size *= length;
			length--;
		}

		List<String> list = new ArrayList<>();
		List<String> destList = new ArrayList<>();

		for (int i = 0; i < input.length(); i++) {
			char charAt = input.charAt(i);
			list.add(String.valueOf(charAt));
		}

		while(destList.size() != size){
			StringBuffer buffer = new StringBuffer();
			for (int i = 0; i < list.size(); i++) {
				buffer.append(list.get(i));
			}
			String str = buffer.toString();
			destList.add(str);
			destList = destList.stream().distinct().collect(Collectors.toList());
			Collections.shuffle(list);
		}

		return destList.stream().sorted().collect(Collectors.toList());
	}
}
