public class Game {
	private final String board;

	public Game(String board) {
		this.board = board;
	}

	public int move(char player) {
		for (int i = 0; i < 9; i++) {
			if (board.charAt(i) == '-') {
				Game game = play(i, player);
				if (game.winner() == player)
					return i;
			}
		}

		for (int i = 0; i < 9; i++) {
			if (board.charAt(i) == '-')
				return i;
		}

		return -1;
	}

	private Game play(int i, char player) {
		return new Game(createNewBoard(i, player));
	}

	private String createNewBoard(int i, char player) {
		StringBuffer newBoard = new StringBuffer(this.board);
		newBoard.setCharAt(i, player);
		return newBoard.toString();
	}

	public char winner() {
		if (board.charAt(0) != '-' && board.charAt(0) == board.charAt(1)
				&& board.charAt(1) == board.charAt(2))
			return board.charAt(0);
		if (board.charAt(3) != '-' && board.charAt(3) == board.charAt(4)
				&& board.charAt(4) == board.charAt(5))
			return board.charAt(3);
		if (board.charAt(6) != '-' && board.charAt(6) == board.charAt(7)
				&& board.charAt(7) == board.charAt(8))
			return board.charAt(6);

		return '-';
	}
}
