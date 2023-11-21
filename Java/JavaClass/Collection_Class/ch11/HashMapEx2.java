package ch11;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapEx2 {
	public static void main(String[] args) {
		HashMap map= new HashMap();
		
		map.put("���ڹ�", 100);
		map.put("���ڹ�", 40);
		map.put("���ڹ�", 80);
		map.put("���ڹ�", 70);
		map.put("���ڹ�", 80);
		
		Set set= map.entrySet();
		Iterator it= set.iterator();
		
		while(it.hasNext()) {
			Entry e = (Entry) it.next();
			System.out.println("�̸� :" + e.getKey() + " ���� :"+ e.getValue());
		}//while
		
		set = map.keySet();
		System.out.println("������ ��� :"+set);
		
		Collection values = map.values();
		it = values.iterator();
		
		int total=0;
		
		while(it.hasNext()) {
			Integer i = (Integer)it.next();
			total += i.intValue();
		}
		
		System.out.println("����"+total);
		System.out.println("��� : "+ (float)total/set.size());
		System.out.println("�ְ� ����" + Collections.max(values));
		System.out.println("�ְ� ����" + Collections.min(values));
		
	}//main
}
