
clear all;
close all;

% Get list of all BMP files in this directory
% DIR returns as a structure array.  You will need to use () and . to get
% the file names.
imagefiles = dir('*.png');      
nfiles = length(imagefiles);    % Number of files found

for i = 1 : nfiles
    im = imread(imagefiles(i).name);
    im = imresize(im, [59, 40]);
    imwrite(im, imagefiles(i).name);
end;