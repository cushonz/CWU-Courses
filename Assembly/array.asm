;Zachary Cushon
;Student ID: 40979699
;I pledge that this submission is solely my work, and that I have neither given, nor received help from anyone.
;10/8/20
    segment .data
a dw -4,22,144                    ;Creates an array of 3 values
b db -3,-16,12                    ;an aditional array of 3 values
c db -14                          ;creates a signed integer with label b and a value of -14
const db -3                       ;creates a constant to be used in the equation
result dq 0                       ;memory of result

    segment .text
    global main
main:
        xor     rax,rax           ;clearing register A
        xor     rbx,rbx           ;clearing register B
        xor     rcx,rcx           ;clearing register C
            
        movsx   rax, word[a]      ;move a into rax
        movsx   rbx, byte[const]  ;move the value -3 into register B
								  ;(alternatively the value stored in location 0 of array b could be used) 
        
        add     rax, rbx          ;adds rax and rbx
        mov     rcx,rax           ;stores the value of rax in rcx 
        movsx   rax, byte[b]      ;moves the first value in array b into rax
        movsx   rbx, byte[c]      ;moves -14 into rbx
        add     rax,rbx           ;adds the two registers together
        sub     rcx,rax           ;subtracts rax from rcx I think
        add    [result],rcx       ;adds rcx to result
        
        movsx   rax, word[a+2]    ;move a into rax
        movsx   rbx, byte[const]  ;move the value -3 into register B
        add     rax, rbx          ;adds rax and rbx
        mov     rcx,rax           ;stores the value of rax in rcx 
        movsx   rax, byte[b+1]    ;moves the first value in array b into rax
        movsx   rbx, byte[c]      ;moves -14 into rbx
        add     rax,rbx           ;adds the two registers together
        sub     rcx,rax           ;subtracts rax from rcx I think
        add    [result],rcx       ;adds rcx to result
        
        movsx   rax, word[a+4]    ;move a into rax
        movsx   rbx, byte[const]  ;move the value -3 into register B
        add     rax, rbx          ;adds rax and rbx
        mov     rcx,rax           ;stores the value of rax in rcx 
        movsx   rax, byte[b+2]    ;moves the first value in array b into rax
        movsx   rbx, byte[c]      ;moves -14 into rbx
        add     rax,rbx           ;adds the two registers together
        sub     rcx,rax           ;subtracts rax from rcx I think
        add    [result],rcx       ;adds rcx to result
     ret  

