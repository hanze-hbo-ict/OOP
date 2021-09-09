#!/bin/sh

mkdir -p build/projects;
cd projects;

for i in */
do
    zip -0 -r "../build/projects/${i%/}.zip" "$i";
done
