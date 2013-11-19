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
		for (int position = 0; position < 9; position += 3)
			if (winnerAtPosition(position))
				return board.charAt(position);

		return '-';
	}

	private boolean winnerAtPosition(int position) {
		return board.charAt(position) != '-' && board.charAt(position) == board.charAt(position + 1)
				&& board.charAt(position + 1) == board.charAt(position + 2);
	}
}
