#include <iostream>
#include <string>
using namespace std;

#define FREE 0
#define MAX 9 // Sudoku board is a 9x9 board
#define DEBUG if (0)

int board[MAX][MAX] = {{0,0,4,1,0,0,3,0,8},
                       {0,1,0,0,0,0,6,2,0},
                       {0,0,8,2,0,0,4,0,0},
                       {0,0,0,3,0,2,8,0,9},
                       {0,0,0,0,7,0,0,0,0},
                       {7,0,1,6,0,8,0,0,0},
                       {5,6,2,0,0,1,7,0,3},
                       {0,3,0,0,0,0,0,4,0},
                       {1,0,0,0,0,5,0,0,0}};

void inputBoard(bool fromFile=true) {
  // Are we reading from a file?
  // Yep?
  if (fromFile) {
    string line;
    cin >> line; // Each line is 81 characters wide
    int lineIndex = 0;
    for (int i=0; i < MAX; i++) {
      for (int j=0; j < MAX; j++) {
        if (line[lineIndex] == '.') {
          board[i][j] = FREE;
          lineIndex++;
        }
        else
          board[i][j] = int(line[lineIndex++]) - '0';
      }
    }
  }
  // Else
  // Use the global configuration
}

bool isPossible(int digit, int row, int col) {
    for (int i = 0; i < MAX; i++) {
        if (board[row][i] == digit || board[i][col] == digit)
            return false;
    }
    int left_most_row = row - (row % 3), left_most_col = col - (col % 3);
    for (int i = left_most_row; i < left_most_row+3; i++) {
        for (int j = left_most_col; j < left_most_col+3; j++) {
            if (board[i][j] == digit)
                return false;
        }
    }
    DEBUG cout << "Yes, from isPossible()" << endl;
    DEBUG cout << digit << " " << row << " " << col << endl;
    return true;
}

bool solve(int curRow, int curCol) {
  int digit;

  DEBUG cout << "\t\t" << curRow << " " << curCol << endl;

  // The backtrack terminates when:
  if (curRow == MAX) // Indexes begin from 0, therefore 0 to MAX-1 are valid
    return true;

  // Any square(board[curRow][curCol] can be either filled or not
  // If the square is filled:
  if (board[curRow][curCol] != 0) {
    // If we've visited all squares in a row, move to the next row
    if (curCol == MAX-1)
      return solve(curRow+1,0);
    // Else, keep going
    return solve(curRow,curCol+1);
  }

  // If the square is not filled:
  // Check for all options(digits)
  for (digit = 1; digit <= MAX; digit++) {

    // Change square-state, if it's valid
    if (isPossible(digit,curRow,curCol)) {
      board[curRow][curCol] = digit;

      // Visit new row if current row is done; Backtracking
      if (curCol == MAX-1) {
        if (solve(curRow+1,0))
          return true;
      }

      // Else, traverse the same row's squares
      else {
        if (solve(curRow,curCol+1))
          return true;
      }
    }
  }
  board[curRow][curCol] = FREE;
  // If we made it till here, something went wrong: Return false
  return false;
}

void printBoard() {
    for (int i = 0; i < MAX; i++) {
        for (int j = 0; j < MAX; j++) {
            cout << board[i][j] << " ";
        }
        cout << endl;
    }
}

void printBoardFormatted() {
  for (int i = 0; i < MAX; i++) {
    for (int j = 0; j < MAX; j++) {
      cout << board[i][j];
    }
  }
  cout << endl;
}

int main(void)
{
  int tc;
  cin >> tc;

  while(tc--) {
    inputBoard(true);
    DEBUG printBoard();
    if (solve(0,0)) {
      DEBUG cout << "Sudoku is solvable!" << endl;
    }
    else {
      DEBUG cout << "Sudoku isn't solvable!" << endl;
    }
    DEBUG printBoard();
    printBoardFormatted();
  }
  return 0;
}
