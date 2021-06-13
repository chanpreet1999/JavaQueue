import java.util.List;
import java.util.ArrayList;

public class TriesImpl {

    public static void main( String[] args ){
        Trie trie = new Trie();

        final List<String> stringsList = new ArrayList<>();
        stringsList.add( "pqrs" );
        stringsList.add( "psst" );
        stringsList.add( "pqrs" );
        stringsList.add( "qprs" );
        
        stringsList.forEach( trie :: insert );
        
        System.out.println( trie.query("pqrs") );
        System.out.println(trie.query("qqaas"));
        
        trie.update("pqrs", "abcd");
        System.out.println( trie.query("pqrs") );
        
        trie.delete("qprs");
        System.out.println( trie.query("qprs") );
        
    }
}

class Trie {
    final TrieNode root;
    Trie() {
        root = new TrieNode();
    }

    public void insert( String str ) {
        TrieNode cur = root;
        for(int i = 0; i < str.length(); i++) {
            if( cur.trieNodes[ str.charAt(i) - 'a' ] == null ) {
                cur.trieNodes[ str.charAt(i) - 'a'] = new TrieNode();
            }
            cur = cur.next( str.charAt(i) );
        }       
        cur.terminating++;
    }

    public void delete( String str ){
        TrieNode cur = root;
        for(int i = 0; i < str.length(); i++) {
            if(cur == null) {
                throw new RuntimeException( "String does not exist" );
            }
            cur = cur.next( str.charAt(i) );
        }
        
        if(cur.terminating != 0) {
            cur.terminating--;
        }

        else {
            throw new RuntimeException( "String does not exist" );
        }

    }

    public void update(String oldStr, String newStr) {
        delete(oldStr);
        insert(newStr);
    }

    public int query(String str)
    {
        TrieNode cur = root;
        for(int i = 0; i < str.length(); i++) {
            if( cur.trieNodes[ str.charAt(i) - 'a' ] == null ) {
                return 0;
            }
            cur = cur.next( str.charAt(i) );
        }       
        return cur.terminating;       
    }
}

class TrieNode {
    final TrieNode[] trieNodes = new TrieNode[26];
    int terminating;
    final TrieNode next(char ch) {
        return trieNodes[ ch - 'a' ];
    }
}