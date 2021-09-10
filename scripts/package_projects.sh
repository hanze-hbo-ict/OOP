#!/bin/sh

mkdir -p build/projects;
rm -rf build/projects/*.zip;

cd projects;


for i in */
do
    zip -0 -r "../build/projects/${i%/}.zip" "$i";
done
