package mars.rover.pojo;

import mars.rover.exception.NotOnPlateauException;

public class Position {
    
	private int x;
	private int y;
    private String coord;
    private Plateau plateau;
	

    public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

    public Position(int x, int y, String coord) {
		this.x = x;
		this.y = y;
        this.coord = coord;
	}

    public Position(int x, int y, String coord, Plateau plateau) {
		this.x = x;
		this.y = y;
        this.coord = coord;
        this.plateau = plateau;
	}

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
	
    public String getCoord() {
        return this.coord;
    }

    public Plateau getPlateau() {
        return this.plateau;
    }

	public void assertRoverIsOnPlateau() {
        Position pos = new Position(this.getX(), this.getY());
        if (x < 0 || x > plateau.getDimX()) {
            throw new NotOnPlateauException(plateau, pos);
        }
        if (y < 0 || y > plateau.getDimY()) {
            throw new NotOnPlateauException(plateau, pos);
        }
	}
	
	public Position move() {
        Position newPosition;
		switch (this.coord) {
			case "E": 
                newPosition = new Position(x + 1, y, coord, plateau);
                newPosition.assertRoverIsOnPlateau();
                return newPosition;
			case "N": 
                newPosition = new Position(x, y + 1, coord, plateau);
                newPosition.assertRoverIsOnPlateau();
                return newPosition;
			case "S": 
                newPosition = new Position(x, y - 1, coord, plateau);
                newPosition.assertRoverIsOnPlateau();
                return newPosition;
			case "W": 
                newPosition = new Position(x - 1, y, coord, plateau); 
                newPosition.assertRoverIsOnPlateau();
                return newPosition;                
			default: throw new RuntimeException("Invalid direction!");
		}      
	}

}
