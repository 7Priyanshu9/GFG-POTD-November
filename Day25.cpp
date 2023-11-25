#include <bits/stdc++.h>
using namespace std;

class Day25
{

public:
  void shuffleArray(int arr[],int n){
    vector<int>v;
    int m =n/2;

    for(int i =0;i<m;i++){
        v.push_back(arr[i]);
        v.push_back(arr[i+m]);
    }

    for(int i = 0;i<n;i++){
        arr[i]= v[i];
    }
  }
};


int main(){
    int t;
    cin>>t;
    while(t--){
        int n;
        cin>>n;
        int a[n];
        for(int i =0;i <n;i++){
            cin>>a[i];
        }


        Day25 ob;
        ob.shuffleArray(a, n);

		for (int i = 0; i < n; i++) 
			cout << a[i] << " ";
    
	
        
	    cout << "\n";
	     
    }
    return 0;
}
    