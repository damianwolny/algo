package com.company;

import java.util.Iterator;
import java.util.LinkedList;

public class HashMapImplementation {

	class Entry {
		int key;
		int val;

		public Entry(int key, int val) {
			this.key = key;
			this.val = val;
		}


	}

	class MyHashMap {
		private int bucketSize = 16;
		private LinkedList<Entry>[] buckets;
		private int nofItem;
		private double loadFactor = 0.75;

		private int hashCode(int idx) {
			return idx % bucketSize;
		}

		public MyHashMap() {
			buckets = new LinkedList[bucketSize];
			nofItem = 0;

		}

		public void put(int key, int value) {
			int hashcode = hashCode(key);
			Entry nEntry = new Entry(key, value);

			if (buckets[hashcode] == null) {
				buckets[hashcode] = new LinkedList<>();
				buckets[hashcode].add(nEntry);
				nofItem++;
				if(overLoad()) reHashing();
			} else {
				boolean found = false;
				for (Entry entry : buckets[hashcode]) {
					if (entry.key == key) {
						entry.val = value;
						found = true;
						break;
					}
				}
				if (!found) {
					buckets[hashcode].add(nEntry);
					nofItem++;
					if(overLoad()) reHashing();
				}
			}

		}

		/**
		 * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
		 */
		public int get(int key) {
			int hashcode = hashCode(key);
			LinkedList<Entry> bucket = buckets[hashcode];
			if (bucket == null) return -1;
			for (Entry entry : bucket) {
				if (entry.key == key) {
					return entry.val;
				}
			}
			return -1;
		}

		public void remove(int key) {
			int hashcode = hashCode(key);
			LinkedList<Entry> buck = buckets[hashcode];
			if (buck == null) return;
			Iterator<Entry> iter = buck.iterator();
			while(iter.hasNext()){
				if(iter.next().key==key){
					iter.remove();
				}
			}

		}

		private boolean overLoad() {
			double currentLoad = (double) nofItem / (double) bucketSize;
			return (currentLoad>loadFactor);
		}

		private void reHashing() {
			LinkedList<Entry>[] temp = buckets;
			bucketSize*=2;
			buckets = new LinkedList[bucketSize];
			for(LinkedList<Entry> tBuck : temp){
				if(tBuck==null) continue;
				for(Entry tEntry : tBuck){
					put(tEntry.key, tEntry.val);
				}
			}
		}
	}


}
