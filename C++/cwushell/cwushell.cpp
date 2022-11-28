#include <iostream>
#include <fstream>
#include <vector>
#include <string>
#include <string.h>
#include <stdio.h>
#include <stdlib.h>
using namespace std;

//Zachary Cushon
//4/13/2022
//CS470

//compile using : g++ cwushell.cpp
//its important that man files are in the same directory as program


void splitOnSpace(string input, vector<string> &vect) 
// Split user input on space, this should catch double spaces
//code reference found at : https://slaystudy.com/c-split-string-by-space-into-vector/

{
    string temp = "";   // Temporary string variable 
    for (int i = 0; i < input.length(); ++i) 
    {
        if (input[i] == ' ') // Loop until a space has been found
        {
            vect.push_back(temp); // Push the collection of characters(string) to the vector
            temp = ""; // Reset temp

        }
        else 
        {
            temp.push_back(input[i]); // Otherwise, push completed parameter to the vector  
        }
    }
    vect.push_back(temp);
}

int main(){
    //Default Values-----------------------
    const string DEF_PROMPT = "cwushell";
    string prompt = DEF_PROMPT;
    bool is_valid = true;

    string user_input_;
    string exit_code = ""; // String to store exit code

         //----MAIN LOOP------------
    while (true)
    {
    cout<<prompt<<" > ";
    getline(cin,user_input_);                          
    vector<string>user_input; // Vector for user input

    splitOnSpace(user_input_, user_input); //Splits user input by space
    if (user_input[0] == "prompt") // Changes the prompt from 'cwushell'
    {
        if (user_input.size() < 2) // If no param use DEF_PROMPT
            prompt = DEF_PROMPT;
        else
            prompt = user_input[1]; // Use first param following the command
            exit_code = "PROMPT";
    }
             
             // CPU info switches ---------------------------------------------------

    else if(user_input[0] == "cpuinfo")
    {

        string line;
        ifstream cpu_info ("/proc/cpuinfo");
        if (user_input.size() > 1)
        {
            exit_code = "CPU_INFO";
            if (user_input[1] == "-c" || user_input[1] == "-C") // -C Code
            {
                for (int i = 0; i < 7;i++) // Skip to correct line
                    getline(cpu_info,line);
                    cout << line <<endl; // Print var line
            }
            else if (user_input[1] == "-n" || user_input[1] == "-N") // -N code
            {
                for (int i = 0; i < 12;i++) 
                    getline(cpu_info,line);
                    cout << line <<endl;
            }
            else if (user_input[1] == "-t" || user_input[1] == "-T") // -T code
            {
                for (int i = 0; i < 5;i++)
                    getline(cpu_info,line);
                    cout << line <<endl;
            }
            else if (user_input[1] == "--help" || user_input[1] == "--Help") // --help code
            {
                string s = "man ./cpuinfo.h";
                char ca[20]; // Maximum size of command since we cant program infinity
                strcpy(ca,s.c_str()); // Copy the string to char array 
                system(ca);
            }
           
        }
        else
        {
            cout << "Try calling 'cpuinfo --help' for information about the cpuinfo command"<<endl;
        }
        
        }
             // [End]---CPU info switches ----------------------------------------------------------





             // [Start] -- meminfo switches---------------------------------------------------------
        else if (user_input[0] == "meminfo")
        {
            

            
            string line;
            ifstream mem_info ("/proc/meminfo");
            if (user_input.size() > 1)
            {
                if (user_input[1] == "-t" || user_input[1] == "-T")
                {
                    getline(mem_info,line);
                    cout << line <<endl;
                }
                else if (user_input[1] == "-u" || user_input[1] == "-U")
                {
                    for (int i = 0; i < 7;i++)
                        getline(mem_info,line);
                    cout << line <<endl;
                }
                else if (user_input[1] == "-c" || user_input[1] == "-C")
                {
                    ifstream cpu_info ("/proc/cpuinfo");
                    for (int i = 0; i < 8;i++)
                        getline(cpu_info,line);
                    cout << line <<endl;
                }
                else if (user_input[1] == "--help" || user_input[1] == "--Help") // --help code
            {
                string s = "man ./meminfo.h";
                char ca[20]; // Maximum size of command since we cant program infinity
                strcpy(ca,s.c_str()); // Copy the string to char array 
                system(ca);
            }
            exit_code = "MEM_INFO";
        }
        else
        {
            cout << "Try calling 'meminfo --help' for information about the meminfo command"<<endl;
        }                
 }
        else if (user_input[0] == "exit" || user_input[0] == "exit")
        {
            cout << "Exit code: " << exit_code<<endl;
            exit(0);
        }
        // [End] -- meminfo ----------------------------------------------------------
        else
        {
            char char_Arr[100]; // Maximum size of command since we cant program infinity
            strcpy(char_Arr,user_input_.c_str()); // Copy the string to char array 
            system(char_Arr); // Pass this through to system 
        }
    }
    return 0;
}