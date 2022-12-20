import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] parents;
	static List<int[]> party;
	static List<Integer> knowing;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		party = new ArrayList<>();
		knowing = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());
		int ans = 0;
		if (num == 0) {
			System.out.println(M);
			return;
		} else {
			int people;
			for(int i=0; i<num; i++) {
				knowing.add(Integer.parseInt(st.nextToken()));
			}
			
			int[] partyPeople;
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				people = Integer.parseInt(st.nextToken());
				partyPeople = new int[people];
				
				for(int j=0; j<people; j++) {
					partyPeople[j] = Integer.parseInt(st.nextToken());
				}
				party.add(partyPeople);
			}
			
			// 모두 자신으로 초기화
			make();
			
			// 같은 파티에 온 사람들 묶기
			int temp;
			for(int i=0; i<M; i++) {
				partyPeople = party.get(i);
				temp = partyPeople[0];
				
				for(int j=1; j<partyPeople.length; j++) {
					union(temp, partyPeople[j]);
				}
			}
			
			// 파티에 참석한 사람이 knowing에 있는 사람과 같은파티에 없다면 ans++
			
			for(int i=0; i<M; i++) {
				boolean flag= false;
				partyPeople = party.get(i);
				for(int j=0; j<partyPeople.length; j++) {
					for(int know : knowing) {
						if(find(know)==find(partyPeople[j])) {
							flag = true;
							break;
						}
					}
				}
				if(!flag) ans++;
			}
			System.out.println(ans);
		}
	}

	static void make() {
		parents = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}

	static boolean union(int x, int y) {
		int xRoot = find(x);
		int yRoot = find(y);
		if (xRoot == yRoot)
			return false;
		else if (xRoot < yRoot) {
			parents[yRoot] = xRoot;
			return true;
		} else {
			parents[xRoot] = yRoot;
			return true;
		}

	}

	static int find(int x) {
		if (x == parents[x])
			return x;
		else
			return parents[x] = find(parents[x]);
	}
}