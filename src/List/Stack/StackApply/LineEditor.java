package List.Stack.StackApply;

import List.Stack.LinkStack;
import java.util.Scanner;

/**
 * @项目名称: DATA_STRUCTURE
 * @类名称: LineEditor
 * @类描述: 行编辑器
 * @创建人: 权义翔
 * @创建时间: 2020/3/6 21:18
 **/
public class LineEditor {
    public static void getEditor() {
        String line = "";
        String record = "";
        Scanner scanner = new Scanner(System.in);
        LinkStack stack = new LinkStack();
        while (!line.equals("exit()")) {
                //清屏
                for (int i = 0; i < 50; i++) {
                    System.out.println(" ");
                }

                System.out.println("           欢迎使用!            ");
                System.out.println("-------------------------------- ");
                if (!"".equals(record)) {
                    System.out.println(record);
                }
                System.out.println("");
                System.out.println("-------------编辑中--------------");
                line = scanner.nextLine();

                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == '#') {
                        stack.pop();
                        continue;
                    }
                    if (line.charAt(i) == '@') {
                        stack.clear();
                        continue;
                    }
                    stack.push(line.charAt(i));
                }
                char[] temp = new char[stack.getLength()];
                for (int i = temp.length - 1; i >= 0; i--) {
                    temp[i] = (char) stack.pop();
                }
                record += new String(temp) + "\n";
                stack.clear();
            }
            System.out.println("see you soon");
        }
    }