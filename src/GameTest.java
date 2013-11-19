import junit.framework.*;

public class GameTest extends TestCase {
	public GameTest(String s) {super(s);}

	public void testOnlyAvailableMove() {
		Game game = new Game("XOXOX-OXO");
		assertEquals(5, game.move('X'));

		game = new Game("XOXOXOOX-");
		assertEquals(8, game.move('O'));
	}
	
	public void testStartingDefaultMove() {
		Game game = new Game("---------");
		assertEquals(0, game.move('X'));
	}
	
	public void testNoAvailableMove() {
		Game game = new Game("XXXXXXXXX");
		assertEquals(-1, game.move('X'));
	}

	public void testFindWinningRowMove() {
		Game game = new Game("OO-XX-OOX");
		assertEquals(5, game.move('X'));
	}

	public void testWinByRowConditions() {
		Game game = new Game("---XXX---");
		assertEquals('X', game.winner());
		
		game = new Game("------OOO");
		assertEquals('O', game.winner());
		
		game = new Game("YYY------");
		assertEquals('Y', game.winner());
	}
}