;Zachary Cushon
;Student ID: 40979699
;I pledge that this submission is solely my work, and that I have neither given, nor received help from anyone.
;11/12/2020
;I was unable to create logic for numbers that are not found anywhere in the array, but I believe I got close and I fixed some problems with my binary search


segment         .data
A               dd 14,10,23,45,17,9,54,22,1,76
size            dd 10
val             dq 0
scanf_format    db "%ld",0
prinf_found     db "Value %ld found in location %ld", 0x0a,0
printf_notfound db "Value not found in array",0x0a,0
prompt          db "Input an integer",0x0a,0
lower           dd 0
upper           dd 9
mid             dd 0



                segment .text
                global main
                global sort
                global search
                extern scanf
                extern printf

                                        ;sort function
                sort:
                
                XOR         RAX, RAX    ;Clear Register A 
                XOR         RBX, RBX    ;Clear Register B 
                XOR         RCX, RCX    ;Clear Register C
                XOR         RDX, RDX    ;Clear Register D 
                _startLoopSort:
                mov  EAX,0              ; swapped = false
                mov  EDX,0

_forLoopSort: 
                cmp [size], ECX         ;i < arr.length
                je  _endforLoopSort
_if:
                mov EDX, [A+ECX*4]      ;move data into EDX for comparison
                mov EBX, [A+(ECX*4)+4]  ;move data into ECX for comparison
                cmp EDX,EBX             ;compare EDX to EBX
                JLE _noswapSort         ;jump to no swap if less than or equal to
                mov [A+(ECX*4)], EBX    ;if no jump continue to swap
                mov [A+(ECX*4)+4], EDX  ;swapping
                mov ECX, 0              ;Set back to begining of array
                mov EAX,1               ;set swap 'variable' to true
                jmp _forLoopSort        ;back to top of loop
             
_noswapSort:
                inc ECX                 ;allow array to shift if no changes are made
                jmp _forLoopSort        ;back to top of for loop
                inc rbx                 ;Increment value being evaluated by for loop
_endforLoopSort:
                cmp    EAX,0            ;Compare EAX to 0     
                JE     _endWhileSort    ;If equal exit loop
                JMP _startLoopSort      ;otherwise back to start
    
_endWhileSort:
                MOV EBX, 10             ;reset size to 10
                MOV EAX, 10             ;SET VALUE HERE COULD NOT GET SCANNER OR PRINTING TO FUNCTION.
                MOV [size], EBX
                MOV [val], EAX
                JMP postsort
                ret
    
    
    
    
    
                search:                 ;search function
                
                searchLoop:
                XOR EAX,EAX             ;Clear register
                XOR EBX,EBX             ;Clear register
                XOR EDX,EDX             ;Clear register
                MOV EAX, [upper]        ;move size into eax for division
                ADD EAX,[lower]
                MOV EBX, 2              ;move 2 into eax for division
                DIV EBX                 ;divide ebx
                MOV [mid], EAX          ;move ebx into mid
                MOV ECX , [A+(EAX*4)]   ;move the value at the given index into ecx
                MOV EAX, [val]          ;move from val to eax for comparison
                CMP EAX,ECX             ;compare ecx and eax
                JG  greater
                JL  less
                JZ end
                greater:                ;adjust based on value found
                MOV EAX,[mid]
                MOV [lower],EAX
                XOR EAX,EAX             ;Clear register
                XOR EBX,EBX             ;Clear register
                XOR EDX,EDX             ;Clear register
                MOV EAX,[mid]           ;move mide to eax
                MOV EBX, 2              ;move 2 to ebx
                DIV EBX                 ;divide
                MOV EBX, [mid]          ;move mid to ebx
                ADD EBX,EAX             ;add ebx and eax
                MOV [mid],EBX           ;move result into mid
                JMP searchLoop          ;restart at top
                less:                   ;if less than zero
                MOV EAX,[mid]           ;move mid to eax
                MOV [upper],EAX         ;make the previous mid the current upper
                XOR EAX,EAX             ;Clear register
                XOR EBX,EBX             ;Clear register
                XOR EDX,EDX             ;Clear register  
                jmp searchLoop             
                end:
                ret

    
                                        ;main functiion
                main:
                MOV EAX, [size]         ;size = n 
                dec EAX                 ;size = n - 1
                Mov [size],eax          ;move from eax to size
               
                call sort               ;call sort function       
                postsort:
                
                
                xor eax,eax
                push rbp                ;setting up stack
                mov rbp, rsp
                frame 0,0,3             ; set up the frame macro
                sub rsp, frame_size
                lea rcx, [prompt]
                call printf
                lea rcx,[scanf_format]
                lea rdx,[val]           
                call scanf              ;call scanf 
                call search             ;call search function
                
                ret
