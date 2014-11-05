package string.dp;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddress {

	/**
	 * @param args
	 * 
	 * This question takes so much details to do in DP...
	 * Very hard to think through the problem
	 * 
	 * 
	 */
	public List<String> restoreIpAddressesDP(String s) {
		if (s == null || s.length() < 4) return new ArrayList<String>();
		List<String> ips = new ArrayList<String>();
		List<List<List<String>>> res = new ArrayList<List<List<String>>>();
		int len = s.length();
		for (int i = 0; i < len; i++){
			List<List<String>> currIps = new ArrayList<List<String>>();
			for (int j = 1; j <= 3; j++){
				if (i - j >= 0){
					List<List<String>> prevIps = res.get(i-j);
					for (List<String> prevIp : prevIps){
						if ((prevIp.size() < 3 || (prevIp.size() == 3 && i == len-1)) && isValid(s.substring(i-j+1, i+1)) ){
							List<String> curr = new ArrayList<String>();
							curr.addAll(prevIp);
							curr.add(s.substring(i-j+1,i+1));
							currIps.add(curr);
						}
					}
				}else {
					String ipPart = s.substring(0, i+1);
					if (isValid(ipPart)){
						List<String> ip = new ArrayList<String>();
						ip.add(ipPart);
						currIps.add(ip);
					}
					break;
				}
			}
			res.add(currIps);
		}
		List<List<String>> finalIps = res.get(res.size()-1);
		for (List<String> ip : finalIps){
			if (ip.size() == 4){
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < ip.size(); i++){
					if (i == 0) sb.append(ip.get(i));
					else sb.append(".").append(ip.get(i));
				}
				ips.add(sb.toString());
			}
		}
		return ips;
	}
	
	private boolean isValid(String s){
		if (s.length() == 1) return true;
		else if (s.length() == 2){
			int ip = Integer.parseInt(s);
			return ip >=10 && ip <= 99;
		} else if (s.length() == 3){
			int ip = Integer.parseInt(s);
			return ip>=100 && ip<=255;
		}
		return false;
	}
	
	/****
	 * This is the DFS approach. Now more and more problems can be solved with DFS. ~~~
	 * It is cleaner than the DP approach.
	 * With the back tracking, I think the efficiency is also acceptable. O(N)
	 * ******/
	public List<String> restoreIpAddresses(String s) {
		List<String> res = new ArrayList<String>();
		List<String> curr = new ArrayList<String>();
		if (s == null || s.length() < 4) return res;
		IpAddressHelper(s, 0, res, curr);
		return res;
	}
	
	private void IpAddressHelper(String s, int index, List<String> res, List<String> curr ){
		if (curr.size() == 4 && index == s.length()){
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < curr.size(); i++){
				if (i==0) sb.append(curr.get(i));
				else sb.append(".").append(curr.get(i));
			}
			res.add(sb.toString());
			return;
		} 
		else if (curr.size() == 4 || index == s.length()) return;
		for (int i = 1; i<= 3 && (i + index) <= s.length(); i++){
			String ipPart = s.substring(index, index+i);
			if (isValid(ipPart)){
				curr.add(ipPart);
				IpAddressHelper(s, index+i, res, curr);
				curr.remove(curr.size()-1);
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
