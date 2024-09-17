class Solution:
    def groupAnagrams(self, strs):
        answer_map = defaultdict(list)#TAKING A LIST IN WHICH THE SUBSEQUENCES ARE TO BE STORED.
        
        for word in strs:#ITERATING EACH WORD IN THE STRS LIST
            sorted_word = ''.join(sorted(word))#SORTING EACH WORDS AND JOINING THEM WITH A SPACE IN BETWEEN THEM
            annwer_map[sorted_word].append(word)#BASICALLY JOINING THOSE WORDS WHICH ARE ANAGRAM OF EACH OTHER.
        
        return list(answer_map.values())#OUR REQUIRED SUBSEQUNCES OF ANAGRAMS.
    
#OR

#include <vector>
#include <string>
#include <unordered_map>
#include <algorithm>

using namespace std;

class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string, vector<string>> anagram_map;  // To store the grouped anagrams
        
        for (const string& word : strs) {  // Iterate through each word in the input list
            string sorted_word = word;  // Copy the word to sort it
            sort(sorted_word.begin(), sorted_word.end());  // Sort the characters of the word
            
            anagram_map[sorted_word].push_back(word);  // Append the original word to the list corresponding to the sorted string
        }
        
        vector<vector<string>> result;  // To store the final grouped anagrams
        for (const auto& entry : anagram_map) {  // Iterate through the map to collect the grouped anagrams
            result.push_back(entry.second);  // Collect each group of anagrams
        }
        
        return result;  // Return the grouped anagrams as a vector of vectors
    }
};
