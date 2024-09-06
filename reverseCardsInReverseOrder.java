// public class Solution {
//     public int[] deckRevealedIncreasing(int[] deck) {
//         int N = deck.length;//finding the length of the deck
//         int[] result = new int[N];//making new array for putting the result elements in it

//         Arrays.sort(deck);//sorting it because we want to sort it obviously to get elements in increasing order.

//         return everyOther(deck, result, 0, 0, false);
//     }

//     private int[] everyOther(int[] deck, int[] result, int indexInDeck, int indexInResult, boolean skip) {
//         int N = deck.length;

//         if (indexInDeck == N) {
//             return result;
//         }

//         while (indexInResult < N) {
//             if (result[indexInResult] == 0) {
//                 if (!skip) {
//                     result[indexInResult] = deck[indexInDeck];
//                     indexInDeck++;
//                 }
//                 skip = !skip;
//             }
//             indexInResult++;
//         }

//         return everyOther(deck, result, indexInDeck, 0, skip);
//     }
// }

// or

class Solution {
    public:
        vector<int> deckRevealedIncreasing(vector<int>& deck) {
            queue<int> qp;
            sort(deck.begin(),deck.end()); //sort the array
            for(int i = deck.size()-1;i>=0;i--){
                if(!qp.empty()){ 
                    qp.push(qp.front()); // push the top element
                    qp.pop(); // pop the element
                }
                qp.push(deck[i]); // then push new element
            }
            for(int i = deck.size()-1;i>=0;i--){
                deck[i] = qp.front(); 
                qp.pop();
            }
            return deck;
        }
    };