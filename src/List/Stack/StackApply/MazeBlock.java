package List.Stack.StackApply;

/**
 * @项目名称: DATA_STRUCTURE
 * @类名称: MazeBlock
 * @类描述: 迷宫块
 * @创建人: 权义翔
 * @创建时间: 2020/3/6 22:50
 **/
public class MazeBlock {
    //标记位（墙，走过，走过不通，未走过）
    public int flag;
    //方位（上下左右）
    public int direction=1;
    public PosType pos;

    public MazeBlock(int flag, int direction, PosType pos) {
        this.flag = flag;
        this.direction = direction;
        this.pos = pos;
    }

    @Override
    public String toString() {
        return "MazeBlock{" +
                "flag=" + flag +
                ", direction=" + direction +
                ", pos=" + pos +
                '}';
    }
}