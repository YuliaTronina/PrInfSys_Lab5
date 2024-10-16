#!/bin/bash

set -e

# Generate outputs from Python scripts
#lr2_output=$(java lab2/src/Lab2.java 27 50 0.001)
#lr3_1_output=$(java lab3/src/Main.java 9 20 8)
#lr3_2_output=$(python3 lab3/task2.py)
#lr3_3_output=$(python3 lab3/task3.py)
lr5_output=$(java src/generalFunctions/Main.java)

# Use perl to replace tabs (\t) with non-breaking spaces and newlines (\n) with <br>
#lr2_output_escaped=$(perl -pe 's/\t/&nbsp;&nbsp;&nbsp;&nbsp;/g; s/\n/<br>/g' <<< "$lr2_output")
#lr3_1_output_escaped=$(perl -pe 's/\t/&nbsp;&nbsp;&nbsp;&nbsp;/g; s/\n/<br>/g' <<< "$lr3_1_output")
#lr3_2_output_escaped=$(perl -pe 's/\t/&nbsp;&nbsp;&nbsp;&nbsp;/g; s/\n/<br>/g' <<< "$lr3_2_output")
#lr3_3_output_escaped=$(perl -pe 's/\t/&nbsp;&nbsp;&nbsp;&nbsp;/g; s/\n/<br>/g' <<< "$lr3_3_output")
lr5_output_escaped=$(perl -pe 's/\t/&nbsp;&nbsp;&nbsp;&nbsp;/g; s/\n/<br>/g' <<< "$lr5_output")

# Use perl to substitute the escaped output into the HTML template
#perl -pi -e "s|{{lr2_output}}|${lr2_output_escaped}|" .github/report-template.html
#perl -pi -e "s|{{lr3_1_output}}|${lr3_1_output_escaped}|" .github/report-template.html
#perl -pi -e "s|{{lr3_2_output}}|${lr3_2_output_escaped}|" .github/report-template.html
#perl -pi -e "s|{{lr3_3_output}}|${lr3_3_output_escaped}|" .github/report-template.html
perl -pi -e "s|{{lr5_output}}|${lr5_output_escaped}|" .github/report-template.html

# Copy the modified template to the output directory
mkdir -p .github/out
cp .github/report-template.html .github/out/index.html