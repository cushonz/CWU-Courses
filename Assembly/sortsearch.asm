;Zachary Cushon
;Student ID: 40979699
;I pledge that this submission is solely my work, and that I have neither given, nor received help from anyone.
;Date : 11/5/20
            segment .data
    
A           dd 14,10,23,45,17,9,54,22,1,76
size        db 9
i           db 0
middle      db 0
index       db 0


            segment .text
            global main
main:
XOR         RAX, RAX                ;Clear Register A 
XOR         RBX, RBX                ;Clear Register B 
XOR         RCX, RCX                ;Clear Register C
XOR         RDX, RDX                ;Clear Register D 


_startLoop:
            mov  EAX,0              ; swapped = false
            mov  EDX,0

_forLoop: 
            cmp [size], ECX         ;i < arr.length
            je  _endforLoop
_if:
            mov EDX, [A+ECX*4]      ;move data into EDX for comparison
            mov EBX, [A+(ECX*4)+4]  ;move data into ECX for comparison
            cmp EDX,EBX             ;compare EDX to EBX
            JLE _noswap             ;jump to no swap if less than or equal to
            mov [A+(ECX*4)], EBX    ;if no jump continue to swap
            mov [A+(ECX*4)+4], EDX  ;swapping
            mov ECX, 0              ;Set back to begining of array
            mov EAX,1               ;set swap 'variable' to true
            jmp _forLoop            ;back to top of loop
             
_noswap:
            inc ECX                 ;allow array to shift if no changes are made
            jmp _forLoop            ;back to top of for loop
            inc rbx                 ;Increment value being evaluated by for loop
_endforLoop:
            cmp    EAX,0            
            JE     _endWhile
            JMP _startLoop 
    
_endWhile:

XOR         RAX, RAX                ;Clear Register A 
XOR         RBX, RBX                ;Clear Register B 
XOR         RCX, RCX                ;Clear Register C
XOR         RDX, RDX                ;Clear Register D 

MOVSX       EAX,byte[size]          ;Move the size variable into EAX for divison
MOV         ECX,[size]              ;Move the size variable into ECX for Comparison

_while2:
            XOR EBX,EBX             ;Clear register to make sure division functions properly
            XOR EDX,EDX             ;Clear register to make sure division functions properly
            MOV EBX, 2              ;Move 2 in each time
            DIV EBX                 ;divide EAX by EBX
            MOV EDX, [A+(eax*4)]    ;Move value at array index
            CMP RDX,RCX             ;Compare RDX,RCX
            JNZ _while2             ;Jump to top of loop
_endWhile2:
MOV         [index], EAX
RET
