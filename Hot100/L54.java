package Hot100;

public class L54 {

    class Trie {
        private Trie[] children;
        boolean isEnd;

        public Trie() {
            children = new Trie[26];
            isEnd = false;
        }

        // abc
        public void insert(String word) {
            Trie node = this;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (node.children[index]==null){
                    // 这个字符还没有元素
                    node.children[index] = new Trie();
                }
                // 走到下一层去，每一层都有26个节点
                node = node.children[index];
            }
            // 该字符全部插入进去,在最后的节点标记完成
            node.isEnd = true;
        }

        public boolean search(String word) {
            Trie node = searchPrefix(word);
            return node!=null && node.isEnd;
        }

        public boolean startsWith(String prefix) {
            Trie node = searchPrefix(prefix);
            return node!=null;
        }

        private Trie searchPrefix(String word){
            // 在前缀树中查找 word
            Trie node = this;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (node.children[index]==null){
                    return null;
                }
                node = node.children[index];
            }
            return node;
        }
    }


}
