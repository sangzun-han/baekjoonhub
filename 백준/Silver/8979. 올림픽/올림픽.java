import java.io.*;
import java.util.*;

class Country implements Comparable<Country>{
    int index;
    int gold;
    int silver;
    int bronze;

    Country(int index, int gold, int silver, int bronze) {
        this.index = index;
        this.gold = gold;
        this.silver = silver;
        this.bronze = bronze;
    }

    @Override
    public int compareTo(Country c) {
        if(this.gold == c.gold && this.silver == c.silver) return c.bronze - this.bronze;
        if(this.gold == c.gold) return c.silver - this.silver;
        return c.gold - this.gold;
    }
}



public class Main {
    public static void main(String[] args) throws Exception{
        List<Country> countryList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        // 정렬 -> 같은 등수인 경우애들이 많으면 문제가 잇을듯
        // 내 위치를 일단 찾고. 나보다 높은애들 몇명이나 존재하는지 앞에서 찾아야할듯
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            countryList.add(new Country(index, gold, silver, bronze));
        }

        Collections.sort(countryList);
        int start = 0;

        for(int i=0; i<countryList.size(); i++) {
            if(K==countryList.get(i).index) {
                start = i;
                break;
            }
        }


        int gold = countryList.get(start).gold;
        int silver = countryList.get(start).silver;
        int bronze = countryList.get(start).bronze;
        int count = 0;
        // 나의 위치는 찾았다.
        // 나보다 앞선애들의 사람 수를 모두 세면 되는데 그 중 나와 동점인 애들은 같은 등수를 가지니 카운트 하지 않는다.
        while(true) {
            if(start == 0) break;

            start--;
            int prevGold = countryList.get(start).gold;
            int prevSilver = countryList.get(start).silver;
            int prevBronze = countryList.get(start).bronze;

            if(prevGold!=gold || prevSilver!=silver || prevBronze!=bronze) {
                count++;
            }

        }
        System.out.println(count+1);
    }

}

