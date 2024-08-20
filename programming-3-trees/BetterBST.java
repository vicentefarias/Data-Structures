public class BetterBST<T extends Comparable<? super T>> extends BinarySearchTree<T>{
    
    public int height(){
        return (height(root));
    }
    public T imbalance(){
        return(imbalance(root));
    }
    public T smallestGreaterThan(T t){
        return(smallestGreaterThan(root, t));
    }
    public BinarySearchTree<T> mirror(){
        return(mirror(root));
    }
    public void prettyPrint(){
    }
    
    
    
    private int height(BinaryNode<T> rt){
        if (rt == null){
            return(-1);
        }
        if (rt.left == null && rt.right == null){
            return(0);
        }
        else if (rt.left == null){
            return(1 + height(rt.right));
        }
        else if (rt.right == null){
            return(1 + height(rt.left));
        }
        else{
            int lheight = height(rt.left);
            int rheight = height(rt.right);
            if (lheight > rheight){
                return(1 + lheight);
            }
             if (rheight > lheight){
                return(1 + rheight);
            }
            else{
                return(1 + lheight);
            }
        }   
    }
    
    
    private T imbalance(BinaryNode<T> rt){
        T imb = null;
        if (rt == null || rt.left == null && rt.right == null){
            imb = null;
        }
        else if (rt.left == null){
            if (height(rt.right)>0){
                return rt.data;
            }
        }
        else if (rt.left == null){
            if (height(rt.right)>0){
                return rt.data;
            }
        }
        else{
            int lheight = height(rt.left);
            int rheight = height(rt.right);
            if (lheight - rheight > 1 || rheight - lheight > 1){
                return (rt.data);
            }
            else{
                T lImbalance = imbalance(rt.left);
                T rImbalance = imbalance(rt.right);
                if (lImbalance != null){ 
                    return(lImbalance);
                }
                if (rImbalance != null){
                    return(rImbalance);
                }
            }
        }
        return(imb);
    }
    
    private T smallestGreaterThan(BinaryNode<T> rt, T data){
        T ret = null;
        T rootData = rt.data;
        int compareResult = data.compareTo(rootData);  
        if (compareResult < 0){
            if (rt.left != null){
                T lData = rt.left.data;       
                if (data.compareTo(lData) > 0){
                    ret = rt.data;
                }
                else{
                    ret = smallestGreaterThan(rt.left, data);
                }
            }
            else{
                ret = rootData;
            }
        }
        if (compareResult > 0){
            if (rt.right != null){
                ret = smallestGreaterThan(rt.right, data);
            }
            else{
                ret = null;
            }  
        }
        if (compareResult == 0){
            if (rt.right != null){
                ret = rt.right.data;
            }
            else{
                ret = null;
            }
        }
        return ret;
    }
    
    
    private BinarySearchTree<T> mirror(BinaryNode<T> rt){
        BinarySearchTree<T> subTree = new BinarySearchTree();
        if (rt != null){
            subTree.root = rt;
            if (rt.left != null && rt.right == null){
                    subTree.root.right = mirror(rt.left).root;
                    subTree.root.left = null;
            }
            if (rt.right != null && rt.left == null){
                    subTree.root.left = mirror(rt.right).root;
                    subTree.root.right = null;
                }
            if (rt.right != null && rt.left != null){
                    subTree.root.left = mirror(rt.right).root;
                    subTree.root.right = mirror(rt.left).root;
                }
            }
        return(subTree);
    }
    
    
    
}