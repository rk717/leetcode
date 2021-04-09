#include <iostream>
#include <unordered_map>

using namespace std; 

int main()
{
    unordered_map<string, double> umap; 

    //inserting values by using [] operator
    umap["PI"] = 3.14; 
    umap["root2"] = 1.414; 
    umap["root3"] = 1.732;
    umap["root10"] = 2.302; 
    umap["loge"] = 1.0; 

    //inserting value by insert function 
    umap.insert(make_pair("e", 2.718));

    string key = "PI"; 

    //if key not found in map iterator to end is returned
    if(umap.find(key) == umap.end()) 
    {
        cout << key << " not found \n\n"; 
    }else{ //// If key found then iterator to that key is returned
        cout << "Found " << key << "\n\n";
    }
        
    ////////////////////////
    key = "lambda";
    if(umap.find(key) == umap.end()){
        cout << key << " not found\n";
    }else {
        cout << "Found " << key << endl;
    }

    //iterating over all value of umap 
    unordered_map<string, double>::iterator itr; 

    cout << " \n all elements: \n";
    for(itr = umap.begin(); itr !=  umap.end(); itr++){
        cout << itr -> first << " " << itr -> second << endl;
    }
    


}