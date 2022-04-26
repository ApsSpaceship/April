	static int[] dx1 = { 1, 0 }; // |-
	static int[] dy1 = { 0, 1 };
	static int[] dx2 = { 1, 2, 1, 0 }; // /|\-
	static int[] dy2 = { -1, 0, 1, 2 };
	static int[][] dx2P = { { 0, 1 }, { 1 }, { 1, 0 }, { 0 } }; // /|\-
	static int[][] dy2P = { { -1, 0 }, { 0 }, { 0, 1 }, { 1 } };
	static char[][] subP;

	public int[] solution(String[][] places) {
		int[] answer = new int[5];

		for (int tc = 0; tc < 5; tc++) {
			answer[tc] = 1; // 거리두기 지키고 있다로 초기화
			subP = new char[5][5];
			for (int i = 0; i < 5; i++)
				subP[i] = places[tc][i].toCharArray();

			point: for (int i = 0; i < 5; i++)
				for (int j = 0; j < 5; j++)
					if (subP[i][j] == 'P' && !check(i, j)) { // 사람 있으면
						answer[tc] = 0;
						break point;
					}

		}

		return answer;
	}

	static boolean check(int x, int y) {
		for (int d = 0; d < 2; d++) { // 거리 1인 곳에 사람 있으면
			int nx = x + dx1[d];
			int ny = y + dy1[d];
			if (nx < 5 && ny < 5 && ny >= 0 && subP[nx][ny] == 'P')
				return false;
		}

		for (int d = 0; d < 4; d++) {
			int nx = x + dx2[d];
			int ny = y + dy2[d];
			if (nx < 5 && ny < 5 && ny >= 0 && subP[nx][ny] == 'P') // 범위 안이면서 거리 2인 곳에 사람 있으면
				for (int i = 0; i < dx2P[d].length; i++) {
					nx = x + dx2P[d][i];
					ny = y + dy2P[d][i];
					if (subP[nx][ny] != 'X') // 파티션 있어야 할 곳에 파티션 없으면
						return false;
				}
		}

		return true;
	}


