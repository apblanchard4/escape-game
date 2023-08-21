Name: Amanda Blanchard

TDD TODO/Task list

**Build Tests**

These are for implementing the EscapeGameBuilder's `makeGameManager()` method.

| **#** | Test                                                            | Comments            |
|:-----:|:----------------------------------------------------------------|:--------------------|
|   1   | Create builder from EGC file.                                   | create game builder |
|   2   | Build game manager 2 X 2, 2 players, and coordinate type SQUARE | create game object  |
 |   3   | Make coordinate (2 x 2)                                         | make coordinate     |
 |   4   | Make a coordinate, get row                                      | make coordinate     |
|   5   | Make a coordinate, Row and Column off board                     | make coordinate     |
|   6   | Get row, invalid row value for this game                        | make coordinate     | 
|   7   | Create square board, no specified                               | make board          |
|   8   | Build game with one CLEAR [default]  location                   | make game           |
|   9   | Build game with no type on locations                            | make game           |
|  10   | Build board with infinite axis                                  | make board          |



*Square Move Tests*

| **#** | Test                                             | Comments        |
|:-----:|:-------------------------------------------------|:----------------|
|  11   | Move piece up 1                                  |                 |  
|  12   | Move up one, piece in other location             | ..              |
|  13   | Move, no piece at the from location              | ..              |
|  14   | Move, piece not owned by player whose turn it is | ..              |
|  15   | Move omni 1, infinite board                      | ..              |
|  16   | Move omni 3 spaces                               | ..              |
|  17   | Move omni check distance                         | ..              |
|  18   | Move omni, distance too far                      | ..              |
|  19   | Move orthogonal                                  | ..              |
|  20   | Move orthogonal distance too far                 | ..              |
|  21   | Move linear                                      | ..              |
|  22   | Move linear, invalid movement                    | ..              |
|  23   | Move linear, piece in the way                    | ..              |
|  24   | Move linear, piece in the way with fly           | ..              |
|  25   | Move diagonal                                    | ..              |
|  26   | Move diagonal, multiple directions               | ..              |
|  27   | Move diagonal, multiple directions, too far      | ..              |
|  28   | Move, to and from are same location              | ..              |
|  29   | Piece at to location belongs to player           | ..              |



*Hex Tests*

| **#** | Test                                           | Comments        |
|:-----:|:-----------------------------------------------|:----------------|
|  30   | Create hex board                               |                 |  
|  31   | Create infinite hex board                      | ..              |
|  32   | Correct Omni movement on hex board             | ..              |
|  33   | Correct omni movement on infinite hex board    | ..              |
|  34   | Incorrect omni, no piece to move               | ..              |
|  35   | Incorrect omni, piece at the final location    | ..              |
|  36   | Incorrect omni, off board                      | ..              |
|  37   | Incorrect omni, too far                        | ..              |
|  38   | Move linear                                    | ..              |
|  39   | Move linear on infinite board                  | ..              |
|  40   | Incorrect linear, too far                      | ..              |
|  41   | Move, to and from are same location            | ..              |
|  42   | Piece at to location belongs to player         | ..              |



*Piece Type Attributes*

| **#** | Test                                        | Comments        |
|:-----:|:--------------------------------------------|:----------------|
|  43   | Incorrect omni, piece at the final location | ..              |
|  44   | Incorrect omni, off board                   | ..              |
|  45   | Incorrect omni, too far                     | ..              |
|  46   | Move linear                                 | ..              |
|  47   | Move linear on infinite board               | ..              |
|  48   | Incorrect linear, too far                   | ..              |



*Multiple Moves*

| **#** | Test                                               | Comments |
|:-----:|:---------------------------------------------------|:---------|
|  49   | Perform two moves in a row, alternating players    | Square   |
|  50   | Two moves, 2nd move is into location of first move | Square   |
|  51   | Three moves, make sure turns are alternating       | Square   |
|  52   | Two moves, both by same player                     | Square   |
|  53   | Two moves, second into new location of first       | Square   |  
|  54   | Perform two moves in a row, alternating players    | Hex      |
|  55   | Two moves, 2nd move is into location of first move | Hex      |
|  56   | Three moves, make sure turns are alternating       | Hex      |
|  57   | Two moves, both by same player                     | Hex      |
|  58   | Two moves, second into new location of first       | Hex      |

*Add Exit*

| **#** | Test                                                          | Comments |
|:-----:|:--------------------------------------------------------------|:---------|
|  59   | Add exit pieces to the board                                  |          |
|  60   | Pass exit piece, failed move                                  | Square   |
|  61   | Pass exit piece with fly, valid move                          | Square   |
|  62   | Pass exit piece, failed move                                  | Hex      |
|  63   | Pass exit piece with fly, valid move                          | Hex      |
|  64   | Land on exit piece, valid move                                | Square   |
|  65   | Land on exit piece, add value of piece, confirm piece removed | Square   |
|  66   | Land on exit piece, valid move                                | Hex      |
|  67   | Land on exit piece, add value of piece, confirm piece removed | Hex      | 
|  68   | Land on exit, linear pattern                                  | Hex      |
|  69   | Land on exit, linear pattern                                  | Square   |

*Add Rules (Turn Limit)*

| **#** | Test                                               | Comments |
|:-----:|:---------------------------------------------------|:---------|
|  70   | Add turn limit to build                            |          |
|  71   | Test turn limit, make move after limit throw error | Square   |
|  72   | Test turn limit, make move after limit throw error | Hex      |
|  73   | Test winner, no points added, tie                  | Square   |
|  74   | Test winner, no points added, tie                  | Hex      |
|  75   | Only player one exits, player 1 wins               | Square   |
|  76   | Only player one exits, player 1 wins               | Hex      |
|  77   | Only player two exits, player 2 wins               | Square   |
|  78   | Only player two exits, player 2 wins               | Hex      |
|  79   | Both players exit, tie                             | Square   | 
|  80   | Both players exit, tie                             | Hex      |
|  81   | Both players exit, player 2 more points            | Square   | 
|  82   | Both players exit, player 2 more points            | Hex      |



*No Rules, End of Game Check*

| **#** | Test                                             | Comments |
|:-----:|:-------------------------------------------------|:---------|
|  83   | Track total pieces in manager                    |          |
|  84   | pieces are being subtracted in manager when exit | Square   |
|  85   | pieces are being subtracted in manager when exit | Hex      |
|  86   | Check for no pieces left                         | Square   |
|  87   | Check for no pieces left                         | Hex      |
|  88   | Get game status when all pieces removed          | Square   |
|  89   | Get game status when all pieces removed          | Hex      |
|  90   | Try to move another after other removed all      |          |
|  91   | Invalid move, end game                           | Square   |
|  92   | Invalid move, end game                           | Hex      | 



*Add Score Rule*

| **#** | Test                                       | Comments |
|:-----:|:-------------------------------------------|:---------|
|  93   | Add score to build                         |          |
|  94   | Score limit is 1, first move wins          | Square   |
|  95   | Score limit is 1, first move wins          | Hex      |
|  96   | Score limit is 2, player two gets 3 points | Hex      |
|  97   | Score limit and turn limit implemented     |          |
|  98   | Score limit is reached before turn limit   | Hex      |
|  99   | Turn limit is reached before turn limit    | Square   | 

*Add Block Locations*

| **#** | Test                                 | Comments |
|:-----:|:-------------------------------------|:---------|
|  100  | Add block to build                   |          |
|  101  | Failed move through block location   | Square   |
|  102  | Failed move through block location   | Hex      |
|  103  | Failed move ending on block location | Square   |
|  104  | Failed move ending on block location | Hex      |
|  105  | Move through block with unblock      | Square   |
|  106  | Move through block with unblock      | Hex      | 
|  107  | Move through block with fly          | Square   |
|  108  | Move through block with fly          | Hex      | 



