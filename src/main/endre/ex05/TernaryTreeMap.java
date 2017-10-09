package ex05;

import org.pg4200.datastructure.map.tree.MyTreeBasedMap;

public class TernaryTreeMap<K extends Comparable<K>, V> implements MyTreeBasedMap<K, V> {

    public class TreeNode{
        private TreeNode left;
        private TreeNode middle;
        private TreeNode right;

        private K firstKey;
        private K secondKey;

        private V firstValue;
        private V secondValue;
    }

    protected TreeNode root;

    protected int size;



    @Override
    public void put(K key, V value) {
        root = put(key, value, root);
    }

    private TreeNode put(K key, V value, TreeNode subTreeRoot){
        if (subTreeRoot == null){
            TreeNode node = new TreeNode();
            node.firstKey = key;
            node.firstValue = value;
            size++;
            return node;
        }

        int fc = key.compareTo(subTreeRoot.firstKey);

        if (fc < 0){
            subTreeRoot.left = put(key, value, subTreeRoot.left);
        }else if (fc == 0){
            subTreeRoot.firstValue = value;
        }else if (fc > 0){

            if (subTreeRoot.secondKey == null){
                size++;
                subTreeRoot.secondKey = key;
                subTreeRoot.secondValue = value;
            } else {
                int sc = key.compareTo(subTreeRoot.secondKey);

                if (sc < 0){
                    subTreeRoot.middle = put(key, value, subTreeRoot.middle);
                }else if (sc == 0){
                    subTreeRoot.secondValue = value;
                }else if (sc > 0){
                    subTreeRoot.right = put(key, value, subTreeRoot.right);
                }
            }
        }
        return subTreeRoot;
    }

    @Override
    public void delete(K key) {
        root = delete(key, root);
    }


    private TreeNode delete(K key, TreeNode subTreeRoot){
        if (subTreeRoot ==  null){
            return null;
        }

        int fc = key.compareTo(subTreeRoot.firstKey);

        if (fc < 0){
            subTreeRoot.left = delete(key, subTreeRoot.left);
            return subTreeRoot;
        }

        if (fc == 0){
            size--;
            if (subTreeRoot.secondKey == null) {

                assert subTreeRoot.right == null;

                if (subTreeRoot.left == null && subTreeRoot.middle == null){
                    return null;
                }

                if (subTreeRoot.left == null){
                    return subTreeRoot.middle;
                } else if (subTreeRoot.middle == null){
                    return subTreeRoot.left;
                } else {
                    TreeNode min = min(subTreeRoot.middle);
                    subTreeRoot.firstKey = min.firstKey;
                    subTreeRoot.firstValue = min.firstValue;
                    subTreeRoot.middle = deleteMin(subTreeRoot.middle);
                    return subTreeRoot;
                }
            } else {

                if (subTreeRoot.middle == null){
                    moveSecondToFirst(subTreeRoot);
                    subTreeRoot.middle = subTreeRoot.right;
                    subTreeRoot.right = null;
                    return subTreeRoot;
                } else if(subTreeRoot.left == null) {
                    moveSecondToFirst(subTreeRoot);
                    subTreeRoot.left = subTreeRoot.middle;
                    subTreeRoot.middle = subTreeRoot.right;
                    subTreeRoot.right = null;
                    return subTreeRoot;
                } else {
                    TreeNode min = min(subTreeRoot.middle);
                    subTreeRoot.firstKey = min.firstKey;
                    subTreeRoot.firstValue = min.firstValue;
                    subTreeRoot.middle = deleteMin(subTreeRoot.middle);
                    return subTreeRoot;
                }
            }
        }

        if (fc > 0){

            if (subTreeRoot.secondKey == null){
                subTreeRoot.middle = delete(key, subTreeRoot.middle);
                return subTreeRoot;
            }

            int sc = key.compareTo(subTreeRoot.secondKey);

            if (sc < 0){
                subTreeRoot.middle = delete(key, subTreeRoot.middle);
                return subTreeRoot;
            }

            if (sc > 0){
                subTreeRoot.right = delete(key, subTreeRoot.right);
                return subTreeRoot;
            }

            assert sc == 0;

            size--;

            if (subTreeRoot.right == null){
                subTreeRoot.secondKey = null;
                subTreeRoot.secondValue = null;
                return subTreeRoot;
            } else {
                TreeNode min = min(subTreeRoot.right);
                subTreeRoot.secondKey = min.firstKey;
                subTreeRoot.secondValue = min.firstValue;
                subTreeRoot.right = deleteMin(subTreeRoot.right);
                return subTreeRoot;
            }
        }

        return subTreeRoot;
    }

    @Override
    public V get(K key) {
        return get(key, root);
    }

    private V get(K key, TreeNode subTreeRoot){
        if (subTreeRoot == null){
            return null;
        }

        int fc = key.compareTo(subTreeRoot.firstKey);

        if (fc < 0){
            return get(key, subTreeRoot.left);
        } else if (fc == 0){
            return subTreeRoot.firstValue;
        } else if (fc > 0){

            if (subTreeRoot.secondKey == null){
                return get(key, subTreeRoot.middle);
            } else {

                int sc = key.compareTo(subTreeRoot.secondKey);
                if (sc < 0){
                    return get(key, subTreeRoot.middle);
                } else if (sc == 0){
                    return subTreeRoot.secondValue;
                } else {
                    return get(key, subTreeRoot.right);
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int getMaxTreeDepth() {

        if (root == null){
            return 0;
        }

        return depth(root);
    }

    protected int depth(TreeNode node){

        int leftDepth = 0;
        int middleDepth = 0;
        int rightDepth = 0;

        if (node.left != null){
            leftDepth = depth(node.left);
        }
        if (node.middle != null){
            middleDepth = depth(node.middle);
        }
        if (node.right != null){
            rightDepth = depth(node.right);
        }

        return 1 + Math.max(leftDepth, Math.max(middleDepth, rightDepth));

    }

    private void moveSecondToFirst(TreeNode subTreeRoot){
        subTreeRoot.firstKey = subTreeRoot.secondKey;
        subTreeRoot.firstValue = subTreeRoot.secondValue;
        subTreeRoot.secondKey = null;
        subTreeRoot.secondValue = null;
    }

    private TreeNode min(TreeNode subTreeRoot){
        if (subTreeRoot.left == null){
            return subTreeRoot;
        }
        return min(subTreeRoot.left);
    }

    private TreeNode deleteMin(TreeNode subTreeRoot){
        if (subTreeRoot.left == null){
            if (subTreeRoot.secondKey == null){
                return subTreeRoot.middle; //might be null
            } else {
                moveSecondToFirst(subTreeRoot);
                subTreeRoot.left = subTreeRoot.middle;
                subTreeRoot.middle = subTreeRoot.right;
                subTreeRoot.right = null;
            }
        }
        subTreeRoot.left = deleteMin(subTreeRoot.left);

        return subTreeRoot;
    }

}
