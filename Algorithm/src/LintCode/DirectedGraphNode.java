package LintCode;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/7/26 0026.
 */
public class DirectedGraphNode {
    int label;
    ArrayList<DirectedGraphNode> neighbors;
    DirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<DirectedGraphNode>();
    }
}
