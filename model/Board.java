/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.28.0.4169.d34df9705 modeling language!*/

package model;

import java.util.*;

// line 2 "model.ump"
// line 16 "model.ump"
public class Board
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Board Associations
  private List<BoardPiece> boardPieces;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Board()
  {
    boardPieces = new ArrayList<BoardPiece>();
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetMany */
  public BoardPiece getBoardPiece(int index)
  {
    BoardPiece aBoardPiece = boardPieces.get(index);
    return aBoardPiece;
  }

  public List<BoardPiece> getBoardPieces()
  {
    List<BoardPiece> newBoardPieces = Collections.unmodifiableList(boardPieces);
    return newBoardPieces;
  }

  public int numberOfBoardPieces()
  {
    int number = boardPieces.size();
    return number;
  }

  public boolean hasBoardPieces()
  {
    boolean has = boardPieces.size() > 0;
    return has;
  }

  public int indexOfBoardPiece(BoardPiece aBoardPiece)
  {
    int index = boardPieces.indexOf(aBoardPiece);
    return index;
  }
  /* Code from template association_IsNumberOfValidMethod */
  public boolean isNumberOfBoardPiecesValid()
  {
    boolean isValid = numberOfBoardPieces() >= minimumNumberOfBoardPieces() && numberOfBoardPieces() <= maximumNumberOfBoardPieces();
    return isValid;
  }
  /* Code from template association_RequiredNumberOfMethod */
  public static int requiredNumberOfBoardPieces()
  {
    return 81;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfBoardPieces()
  {
    return 81;
  }
  /* Code from template association_MaximumNumberOfMethod */
  public static int maximumNumberOfBoardPieces()
  {
    return 81;
  }
  /* Code from template association_AddMNToOnlyOne */
  public BoardPiece addBoardPiece(int aRow, int aColumn, int aNumber)
  {
    if (numberOfBoardPieces() >= maximumNumberOfBoardPieces())
    {
      return null;
    }
    else
    {
      return new BoardPiece(aRow, aColumn, aNumber, this);
    }
  }

  public boolean addBoardPiece(BoardPiece aBoardPiece)
  {
    boolean wasAdded = false;
    if (boardPieces.contains(aBoardPiece)) { return false; }
    if (numberOfBoardPieces() >= maximumNumberOfBoardPieces())
    {
      return wasAdded;
    }

    Board existingBoard = aBoardPiece.getBoard();
    boolean isNewBoard = existingBoard != null && !this.equals(existingBoard);

    if (isNewBoard && existingBoard.numberOfBoardPieces() <= minimumNumberOfBoardPieces())
    {
      return wasAdded;
    }

    if (isNewBoard)
    {
      aBoardPiece.setBoard(this);
    }
    else
    {
      boardPieces.add(aBoardPiece);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeBoardPiece(BoardPiece aBoardPiece)
  {
    boolean wasRemoved = false;
    //Unable to remove aBoardPiece, as it must always have a board
    if (this.equals(aBoardPiece.getBoard()))
    {
      return wasRemoved;
    }

    //board already at minimum (81)
    if (numberOfBoardPieces() <= minimumNumberOfBoardPieces())
    {
      return wasRemoved;
    }
    boardPieces.remove(aBoardPiece);
    wasRemoved = true;
    return wasRemoved;
  }

  public void delete()
  {
    for(int i=boardPieces.size(); i > 0; i--)
    {
      BoardPiece aBoardPiece = boardPieces.get(i - 1);
      aBoardPiece.delete();
    }
  }

}