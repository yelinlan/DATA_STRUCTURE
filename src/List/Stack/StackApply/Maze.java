package List.Stack.StackApply;

import List.Stack.LinkStack;

import java.util.Random;

/**
 * @项目名称: DATA_STRUCTURE
 * @类名称: Maze
 * @类描述: 迷宫
 * @创建人: 权义翔
 * @创建时间: 2020/3/6 22:38
 **/
public class Maze {
    //初始化因子，数字越大，障碍越少
    protected int FACTOR = 3;
    //边界定义 "#"
    protected final int BORDER = -1;
    //生成空
    protected final int EMPTY = 0;
    //通过 "!"
    protected final int PASS = 1;
    //走过但不通 "@"
    protected final int PASSNOT = -2;
    //入口 "A"
    //出口 "B"

    protected MazeBlock block;
    public int[][] arr = new int[10][10];
    protected int row = 10;
    protected int col = 10;

    public Maze(int row, int col) {
        this.arr = new int[row][col];
        this.row = row;
        this.col = col;
    }

    public Maze() {
    }

    /**
     * @return : void
     * @方法名 : initMaze
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/7 8:35
     * @功能描述 : 初始化迷宫
     */
    public void initMaze(int... factor) {
        //设置自定义初始化因子
        if (factor.length != 0) {
            FACTOR = factor[0];
        }
        Random rand = new Random();
        //塑造边界墙
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                this.arr[i][j] = BORDER;
            }
        }
        //随机生成通路
        for (int i = 1; i < row - 1; i++) {
            for (int j = 1; j < col - 1; j++) {
                if (i == 1 && j == 1) {
                    this.arr[i][j] = EMPTY;
                } else if (i == row - 2 && j == col - 2) {
                    this.arr[i][j] = EMPTY;
                } else if (rand.nextInt(100) % FACTOR != 0) {
                    this.arr[i][j] = EMPTY;
                }
            }
        }
    }
    /**
     * @方法名 : doMaze
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/19 23:08
     * @功能描述 : 走迷宫
     *
     * @return : void
     */
    public void doMaze() {

        //进口，出口
        PosType startPosType = new PosType(1, 1);
        PosType endPosType = new PosType(row - 2, col - 2);
        MazeBlock start = new MazeBlock(EMPTY, 0, startPosType);
        MazeBlock end = new MazeBlock(EMPTY, 0, endPosType);

        LinkStack<MazeBlock> stack = new LinkStack<>();
        stack.push(start);
        //栈不空
        while (!stack.isEmpty()) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this);
            MazeBlock curMazeBlock = stack.pop();
            //找到出口
            if (curMazeBlock.pos.equals(end.pos)) {
                System.out.println("找到通路！");
                return;
            }
            //
            if (curMazeBlock.flag == EMPTY) {
                if (curMazeBlock.direction != 4) {
                    //更新方向
                    curMazeBlock.direction++;
                    stack.push(curMazeBlock);
                    //按规律获取下一位置
                    MazeBlock nextMazeBlock = nextMazeBlock(arr, curMazeBlock);
                    if (nextMazeBlock != null) {
                        mark(stack.getTop(), PASS);
                        stack.push(nextMazeBlock);
                    }
                } else if (curMazeBlock.direction == 4) {
                    while (!stack.isEmpty()&&curMazeBlock.direction == 4) {
                        //如果没有方向,标记通不过
                        mark(curMazeBlock, PASSNOT);
                        //出栈
                        curMazeBlock = stack.pop();
                    }
                    stack.push(curMazeBlock);
                }
            }
        }
        System.out.println("没找到通路");
        return;
    }

    /**
     * @return : void
     * @方法名 : mark
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/7 11:50
     * @功能描述 : 标记迷宫块
     */
    public void mark(MazeBlock mazeBlock, int markSymbol) {
        this.arr[mazeBlock.pos.x][mazeBlock.pos.y] = markSymbol;
    }

    /**
     * @return : MazeBlock
     * @方法名 : nextMazeBlock
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/7 11:29
     * @功能描述 : 获取下一个迷宫块
     */
    protected MazeBlock nextMazeBlock(int[][] arr, MazeBlock mazeBlock) {
//        换一个方向
        PosType nextPosType = new PosType(mazeBlock.pos.x, mazeBlock.pos.y);
        switch (mazeBlock.direction) {
            //UP = 3;
            case 3:
                nextPosType.x--;
                break;
            // LEFT = 4;
            case 4:
                nextPosType.y--;
                break;
            //DOWN = 1;
            case 1:
                nextPosType.x++;
                break;
            //RIGHT = 2;
            case 2:
                nextPosType.y++;
                break;
            default:
                return null;
        }
        //越界
        if (isOutOfXBounds(nextPosType)) {
            System.out.println("数组越界");
            return null;
        }
        //障碍或已走过
        int state = arr[nextPosType.x][nextPosType.y];
        if (state == BORDER) {
            System.out.println("边界");
            return null;
        }
        if (state == PASSNOT) {
            System.out.println("走过但走不通");
            return null;
        }
        if (state == PASS) {
            System.out.println("走过");
            return null;
        }
        return new MazeBlock(state, 0, nextPosType);
    }

    /**
     * @return : boolean
     * @方法名 : isOutOfXBounds
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/7 13:20
     * @功能描述 : 坐标越界
     */
    public boolean isOutOfXBounds(PosType pos) {
        return !(pos.x < this.row && pos.x >= 0 && pos.y < this.col && pos.y >= 0);
    }

    /**
     * @return : String
     * @方法名 : toString
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/7 9:18
     * @功能描述 : 输出迷宫
     */
    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 1 && j == 1) {
                    str += "A  ";
                } else if (i == row - 2 && j == col - 2) {
                    str += "B  ";
                } else if (arr[i][j] == BORDER) {
                    str += "#  ";
                } else if (arr[i][j] == EMPTY) {
                    str += "   ";
                } else if (arr[i][j] == PASSNOT) {
                    str += "@  ";
                } else if (arr[i][j] == PASS) {
                    str += "!  ";
                }
            }
            str += "\n";
        }
        return str;
    }
}