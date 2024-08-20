public class BetterBSTTester<T extends Comparable<? super T>>{
    public static void main(String[] args){
        BetterBST tree = new BetterBST();
        tree.insert(20);
        tree.insert(10);
        tree.insert(30);
        tree.insert(15); 
        tree.insert(25);
        tree.insert(24);
        tree.insert(26); 
        tree.insert(31); 
        tree.insert(32); 
        tree.insert(33); 
        BinarySearchTree mirror = tree.mirror();
    }
}