
public class Game {
	private static final int ROW_LENGTH = 3;
	private static final char AVAILABLE_POSITION = '-';
	private static final char NO_WINNER = '-';
	private final String board;

	public Game(String board) {
		this.board = board;
	}

	public int move(char player) {
		for (int index = possibleMove(0); isAPossibleMove(index); index = possibleMove(index + 1))
			if (doesPlayerWin(player, index))
				return index;

		return possibleMove(0);
	}

	private boolean doesPlayerWin(char player, int possibleMove) {
		StringBuffer newBoard = new StringBuffer(this.board);
		newBoard.setCharAt(possibleMove, player);
		return new Game(newBoard.toString()).winner() == player;
	}

	private boolean isAPossibleMove(int index) {
		return index != -1;
	}

	private int possibleMove(int fromIndex) {
		return board.indexOf(AVAILABLE_POSITION, fromIndex);
	}

	public char winner() {
		for (int position = 0; position < board.length(); position += ROW_LENGTH)
			if (winnerAtPosition(position))
				return board.charAt(position);

		return NO_WINNER;
	}

	private boolean winnerAtPosition(int position) {
		return board.charAt(position) != AVAILABLE_POSITION && board.charAt(position) == board.charAt(position + 1)
				&& board.charAt(position + 1) == board.charAt(position + 2);
	}
}
