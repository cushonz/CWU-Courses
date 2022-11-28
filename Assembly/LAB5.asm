;Zachary Cushon
;Student ID: 40979699
;I pledge that this submission is solely my work, and that I have neither given, nor received help from anyone.
;Date: 10/30/20

    segment .data
   t     dw  0x515E
   day   dw  0
   month db  0
   year  dw 1980
   
   segment .text
   global main
  main:
  xor   EDX,EDX     ; Clear register E
  xor   DX, DX      ; Clear register D
  mov   DX, [t]     ; move the hex value into register D
  shr   DX, 9
  add   [year], DX  ; add the result to the variable year
  mov   DX, [t]     ; move the hex value into register D
  shl   DX, 11      ; shift register DX 12 to the left
  shr   DX, 11      ; shift register DX 12 to the right
  add   [day], DX   ; add result to variable day
  mov   DX, [t]     ; Move t back into DX
  shl   DX,7        ; shift register DX 7 to the left      
  shr   DX,12       ; shift register DX 12 to the right
  add [month], DX   ; add to month variable
  ret
