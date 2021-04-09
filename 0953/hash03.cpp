#include <bits/stdc++.h>

using namespace std; 

//print frequecies of individual words in str
void printFrequencies(const string& str)
{
    unordered_map<string, int> wordFreq; 

    //breaking input into word using string stream
    stringstream ss(str); //used for breaking words
    string word;  //to store individual words
    while(ss >> word){
        wordFreq[word]++; 
    }

    //now iterating over word, freq pair and printing 
    //them in < , > format 
    unordered_map<string, int> :: iterator p; 
    for(p=wordFreq.begin(); p!=wordFreq.end(); p++)
    {
        cout << "( " << p->first << ", " << p->second << " )" << endl; 
    }
}

int main(){
    string str = "geeks for geeks geeks quiz"
    "practice qa for"; 
    printFrequencies(str); 

    return 0; 
}