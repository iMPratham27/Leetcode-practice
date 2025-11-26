class WordDictionary {

    private TrieNode root;

    public WordDictionary(){
        root = new TrieNode();
    }

    public void addWord(String word){
        TrieNode current = root;
        for(char c: word.toCharArray()){
            int index = c - 'a';
            if(current.children[index] == null){
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEnd = true;
    }

    public boolean search(String word){
        return searchInNode(word, root);
    }

    private boolean searchInNode(String word, TrieNode node){
        TrieNode current = node;

        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);

            if(c == '.'){
                for(TrieNode child: current.children){
                    if(child != null){
                        if(searchInNode(word.substring(i+1), child)){
                            return true;
                        }
                    }
                }

                return false;

            }else{
                int index = c - 'a';
                if(current.children[index] == null){
                    return false;
                }
                current = current.children[index];
            }
        }

        return current.isEnd;
    }
}
